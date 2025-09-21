package Sneha.com.Generics;

interface Printable{
      
      void print();
}


class MyNumber extends Number implements Printable{
      
      private final int val;
      
      
      public MyNumber(int val){
            this.val = val;
      }
      
      @Override
      public void print(){
            System.out.println("My Number = "+this.val);
      }
      
      @Override
      public int intValue(){
            return this.val;
      }
      
      @Override
      public float floatValue(){
            return this.val;
      }
      
      @Override
      public double doubleValue(){
            return this.val;
      }
      
      @Override
      public long longValue(){
            return this.val;
      }
      
}

class Boxx<T extends Number & Printable >{
      
      private T i;
      
      public Boxx(T i){
            this.i=i;
      }
      
      public void display(){
            i.print();
      }
      
      public T geti(){
            return i;
      }
      

}

public class Test{
      
      public static void main(String[] args){
            
            MyNumber myNumber = new MyNumber(12);
            Boxx<MyNumber> box = new Boxx<>(myNumber);
            box.display();
      }
}