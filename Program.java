/*
 * RASHAAD SAUNDERSON
 * CISC 3130
 * HOMEWORK #1
 */
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Program{
   public static void main(String[] args){
      ArrayList<Customer> customers = new ArrayList<>();
      
      try{
         File master = new File("MasterFile.txt");
         FileReader fileReader = new FileReader(master);
         BufferedReader buffReader = new BufferedReader(fileReader);
         String line;
         
         String regex = "(\\s)+"; 
         
         while((line = buffReader.readLine()) != null){
         
            String[] columns = line.trim().split(regex); 
            String name = columns[1].trim();
            
            int customer_id = Integer.parseInt(columns[0].trim());
            double balanceDue = Double.parseDouble(columns[2].trim());
            Customer customer = new Customer(name, customer_id, balanceDue); 
            customers.add(customer); 
            
            File transaction = new File("Transactions.txt");
            FileReader transReader = new FileReader(transaction);
            BufferedReader transBuffer = new BufferedReader(transReader);
            String transLine;
            
               while ((transLine = transBuffer.readLine()) != null){
                  String[] splited = transLine.trim().split(regex);
                  char code = splited[0].trim().toUpperCase().charAt(0);
                  int cust_id = Integer.parseInt(splited[1].trim());
                  
                  if (cust_id != customer.getCustomer_id())
                     continue;
                  
                  switch (code){
                   case 'P':{
                     int transNum = Integer.parseInt(splited[2].trim());
                     double amount = Double.parseDouble(splited[3].trim());
                     Transaction trans = new Payment(transNum, amount);
                     customer.addTransaction(trans);
                     
                     break;
                   }
                   
                   case 'O': {
                    int transNum = Integer.parseInt(splited[2].trim());
                    String item = splited[3].trim();
                    int quantity = Integer.parseInt(splited[4].trim());
                    double cost = Double.parseDouble(splited[5].trim());
                    
                    Transaction trans = new Order(transNum, item, quantity, cost);
                    customer.addTransaction(trans);
                    
                    break;
                   }
                 }
               }
               
              transBuffer.close();
            }
           
              fileReader.close();
       }
       catch (IOException e) {
         e.printStackTrace();
       }
       
       try {
         FileWriter fstream = new FileWriter("output.txt");
         BufferedWriter out = new BufferedWriter(fstream);
         
         for (Customer cust: customers){
            out.write(cust.Print());
         }
         
       out.close();
       }
       
       catch (Exception e) {
         System.err.println("Error: " +e.getMessage());
       }  
   }
}