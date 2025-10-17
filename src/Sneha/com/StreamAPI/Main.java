//Using Filter

package Sneha.com.StreamAPI;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
      
      public static void main(String[] args){
      
            List<Integer> arr = Arrays.asList(9,2,8,4,7);
            
            
            // 1st Approach using lambda expression
            Predicate<Integer> predicate =integer -> integer % 2 == 1;
            
            Function<Integer, Integer> map = integer -> integer*2;
            
            arr.stream()
                    .filter(predicate)
                    .sorted()
                    .map(map)
                    .forEach(System.out::println);
            
            System.out.println("-------------------");
            
            // 2nd Approach direct using the logic in the function call
            arr.stream()
                    .filter(n->n%2==1)
                    .sorted()
                    .map(n->n*2)
                    .forEach(System.out::println);
      }
}
