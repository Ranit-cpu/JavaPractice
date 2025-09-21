package Sneha.com.examples;

public class Hex extends Num
{
      public Hex(int num)
      {
            super(num);
      }
      
      public void print()
      {
            super.print();
            System.out.println("The Hexa-Decimal value is = "+Integer.toHexString(num).toUpperCase());
      }
}
