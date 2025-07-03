package Sneha.com.MultiThreading;

public class Demo3 {

    public static void main(String[] args){

        Runnable  obj1 = () -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("CCC ");
                try{
                    Thread.sleep(10);
                }catch(InterruptedException e){
                    System.out.println("Thread not slept. Exception caught!");
                }
            }
            System.out.println();
        };
        Runnable obj2 = new D();

        //obj2.setPriority(Thread.MAX_PRIORITY);

        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        t1.start();
        t2.start();
    }
}
