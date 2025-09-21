package Sneha.com.Generics;

public class EqualsTest {
      
      public static void main(String[] args){
      
            ABC ob1 = new ABC(8);
            ABC ob2 = new ABC(8);
            
            if(ob1.equals(ob2)){
                  System.out.println("Both objects are equal.");
            }
      }
}

class ABC{
      
      private int n;
      
      public int getN() {
            return n;
      }
      
      public ABC(int n) {
            this.n = n;
      }
      
      @Override
      public boolean equals(Object o){
            
            if((o instanceof ABC) && ((ABC)o).getN()== this.n){
                  return true;
            }else {
                  return false;
            }
      }
}