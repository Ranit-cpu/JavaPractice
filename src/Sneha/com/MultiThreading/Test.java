package Sneha.com.MultiThreading;

class C implements Runnable{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("CCC ");
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                System.out.println("Thread not slept. Exception caught!");
            }
        }
        System.out.println();
    }
}

class D implements Runnable{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("DDDD ");
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                System.out.println("Thread not slept. Exception caught!");
            }
        }
        System.out.println();
    }
}

class A extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("Hi ");
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                System.out.println("Thread not slept. Exception caught!");
            }
        }
        System.out.println();
    }
}

class B extends Thread{
    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.println("Hello ");
            try{
                Thread.sleep(10);
            }catch(InterruptedException e){
                System.out.println("Thread not slept. Exception caught!");
            }
        }
        System.out.println();
    }
}