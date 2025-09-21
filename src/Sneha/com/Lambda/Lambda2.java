package Sneha.com.Lambda;

interface LambdaThread{
      public void demo();
      //public void demo2();
}

public class Lambda2
{
      public static void main(String[] args){
            Thread t = new Thread(new Runnable() {
                  @Override
                  public void run() {
                  
                  }
            });
      }
}
