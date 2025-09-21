package Sneha.com.Networks;

class Dog{
      void sound(){
            System.out.println("Dog");
      }
}

class Breed{
      void sound(){
            System.out.println("Labrador");
      }
}

public class Animal{

      public static void main(String[] args){
            
            Breed an = new Breed();
            Dog ca = new Dog();
            
            an.sound();
            ca.sound();
      }
}
