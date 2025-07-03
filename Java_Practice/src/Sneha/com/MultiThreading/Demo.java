package Sneha.com.MultiThreading;

public class Demo {

    public static void main(String[] args){

        A obj1 = new A();
        B obj2 = new B();

        obj2.setPriority(Thread.MAX_PRIORITY);

        obj1.start();
        obj2.start();
    }
}