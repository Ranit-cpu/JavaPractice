package Sneha.com.MultiThreading;

public class Demo3 {

    public static void main(String[] args){

        //Lambda Expression 1
        Runnable  obj1 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("C3 ");
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    System.out.println("Thread not slept. Exception caught!");
                }
            }
            System.out.println();
        };
        
        //Lambda Expression 2
        Runnable obj2 = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println("D4 ");
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    System.out.println("Thread not slept. Exception caught!");
                }
            }
            System.out.println();
        };

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
    }
}