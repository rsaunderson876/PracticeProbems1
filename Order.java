/*
 * RASHAAD SAUNDERSON
 * CISC 3130
 * HOMEWORK #1
 */
 
public class Order extends Transaction{

   private String item;
   private int quantity;
   private double cost;
   
   public Order(int transNo, String item, int quantity, double cost){
      super(transNo);
      
      this.item = item;
      this.quantity = quantity;
      this.cost = cost;
   }
   
   public double getCost(){
      return cost;
   }
   
   public double getTotal(){
      return cost*quantity;
   }
   
   public String getItem(){
      return item;
   }
   
   public int getQuantity(){
      return quantity;
   }
   
   @Override
   public String toString(){
      return super.toString()+ "\t" +getItem()+ " ordered:\t$" 
                              +getTotal()+ "\n";
   }
}