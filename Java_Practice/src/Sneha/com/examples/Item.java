package Sneha.com.examples;

public class Item
{
      private final String code;
      private final int price;
      
      public Item(String code, int price)
      {
            this.code = code;
            this.price = price;
      }
      
      //getter for code
      private String getCode()
      {
            return code;
      }
      
      //getter for price
      private int getPrice()
      {
            return price;
      }
      
      public void display()
      {
            System.out.println(this.getCode()+"\t$"+this.getPrice());
      }
}
