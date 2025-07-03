package Sneha.com.Collections;

//ArrayLists Strings

import java.util.ArrayList;

public class AlistString {
      public static void main(String[] args){
            ArrayList<String> list = new ArrayList<>();
            
            list.add("Ranit");
            list.add("Sneha");
            list.add("Rima");
            list.add("Deep");
            list.add("Jishnu");
            list.add("Deep");
            
            System.out.println(list.remove("Deep"));
            System.out.println(list);
            System.out.println(list.set(4,"Deep"));
            System.out.println(list);
            System.out.println(list.indexOf("Rima"));
      }
}
