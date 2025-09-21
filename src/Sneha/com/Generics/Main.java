package Sneha.com.Generics;



public class Main {

      public static void main(String[] args){
            
//            Pair<String, Integer> p = new Pair<>("Age", 21);
//
//            System.out.println(p.getKey());
//            System.out.println(p.getVal());
            
            Box<Integer> box = new Box<>(5);
            
            box.setVal(5);
            
            System.out.println(box.getVal());
      }
}