package Sneha.com.Lambda;

@FunctionalInterface
interface Lambda{
      void demo();
}

public class Lambda1 {
      public static void main(String[] args){
            Lambda lambda = ()->{System.out.println("Statement 01");
                              System.out.println("Statement 02");};
            lambda.demo();
      }
}