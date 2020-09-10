/*
 * RASHAAD SAUNDERSON
 * CISC 3130
 * HOMEWORK #1
 */
 
 
 public abstract class Transaction{
   int transNum;
   
   public Transaction(int transNum){
      super();
      this.transNum = transNum;
   }
   
   public int getTransaction(){
      return transNum;
   }
   
   @Override
   public String toString(){
      return "Transaction: "+getTransaction();
   }
 }