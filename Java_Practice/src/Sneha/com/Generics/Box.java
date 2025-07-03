package Sneha.com.Generics;

public class Box<T extends Number>{
      
      private T val;
      
      public Box(T val){
            this.val = val;
      }
      
      public T getVal() {
            return val;
      }
      
      public void setVal(T val) {
            this.val = val;
      }
}