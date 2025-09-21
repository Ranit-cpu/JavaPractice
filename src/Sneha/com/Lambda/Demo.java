package Sneha.com.Lambda;

@FunctionalInterface
interface A{
      void show(int i);
}

@FunctionalInterface
interface B{
      public int add(int i, int j);
}

public class Demo {
      public static void main(String[] args){
            
            B obj = (i,j)-> i+j;
            int result  = obj.add(5,8);
            System.out.println(result);
      }
}
