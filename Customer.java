/*
 * RASHAAD SAUNDERSON
 * CISC 3130
 * HOMEWORK #1
 */
 
import java.util.ArrayList;

public class Customer{

   private String name;
   private int customer_id;
   private double balanceDue;
   private ArrayList<Transaction> transactions;
   
   public Customer(int customer_id){
      this.customer_id = customer_id;
   }
   
   public Customer (String name, int customer_id, double balanceDue){
      super();
      this.name = name;
      this.customer_id = customer_id;
      this.balanceDue = balanceDue;
      this.transactions = new ArrayList<>();
   }
   
   public void addTransaction(Transaction trans){
      transactions.add(trans);
   }
   
   public void balanceUpdate(){
      for (Transaction trans: transactions){
         if (trans instanceof Order){
            Order order = (Order) trans;
            balanceDue = balanceDue + order.getCost();
          }    
                
         else if (trans instanceof Payment) {
            Payment payment = (Payment) trans;
            balanceDue = balanceDue - payment.getAmount();
          }
         }
      }
   
   @Override
   public boolean equals(Object obj){
      if (obj != null && obj instanceof Customer){
         Customer customer = (Customer) obj;
         return getCustomer_id() == customer.getCustomer_id();
      }
      
      return false;
   }
   
   public String getName(){
      return name;
   }
   
   public int getCustomer_id(){
      return customer_id;
   }
   
   public double getBalanceDue(){
      return balanceDue;
   }
   
   public ArrayList<Transaction> getTransactions(){
      return transactions;
   }
   
   @Override
   public String toString(){
      return "Customer [name = " +name+ ", customer_id = "+customer_id+ 
                        ", balanceDue = "+balanceDue+ "]";
   }
   
   public String Print(){
      String output = " ";
      output = output + getName()+"\t" + getCustomer_id()+"\n\n\t\t"
                 +"Previous Balance: \t$"+getBalanceDue()+"\n\n";
                 
       for(Transaction trans:transactions){
         output = output + trans.toString();
       }
       balanceUpdate();
       output = output + "\n\n\t\t\t"+ "Balance Due: \t$"
                           +getBalanceDue()+ "\n";
       return output;
       
   }
}
   
   
