package Sneha.com.MultiThreading;

public class Demo2 {

    public static void main(String[] args) {

        //Runnable  obj1 = new C();
        Runnable obj2 = new D();

        //obj2.setPriority(Thread.MAX_PRIORITY);

        //Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);

        //t1.start();
        t2.start();
    }
}