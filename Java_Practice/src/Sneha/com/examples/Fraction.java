package Sneha.com.examples;

public class Fraction
{
      private final int numerator;
      private final int denominator;
      
      public Fraction(int numerator, int denominator)
      {
            this.numerator = numerator;
            this.denominator = denominator;
      }
      
      public Fraction(int numerator){
            this(numerator, 1);
      }
      
      public Fraction(){
            this(1, 1);
      }
      
      public void display()
      {
            if(denominator == 0)
            {
                  System.out.println("Invalid Fraction");
                  return;
            }
            System.out.println(numerator+"/"+denominator);
      }
}
