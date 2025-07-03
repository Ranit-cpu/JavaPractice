package Sneha.com.Generics;



public class EnumGenerics {
      
      public static void main(String[] args){
      
            EnumGenerics ob = new EnumGenerics();
            Integer[] arr = {1,2,3,4,5,6,7};
            ob.printArray(arr);
      }
      
      public <T> void printArray(T[] parameter){
            //method body
            for(T i : parameter){
                  System.out.print(i+" ");
            }
            
      }
}
