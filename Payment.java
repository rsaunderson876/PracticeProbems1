/*
 * RASHAAD SAUNDERSON
 * CISC 3130
 * HOMEWORK #1
 */
 
public class Payment extends Transaction{

   private double amount;
   
   public Payment(int transNo, double amount){
      super(transNo);
      this.amount = amount;
   }
   
   public double getAmount(){
      return amount;
   }
   
   @Override
   public String toString(){
      return super.toString() + "\t Payment: \t" 
                                +getAmount()+ "\n";
   }
}