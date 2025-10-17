//Use of Reduce function

package Sneha.com.StreamAPI;

import java.util.Arrays;
import java.util.List;

public class Demo3 {
      public static void main(String[] args) {
            
            List<Integer> arr = Arrays.asList(9, 2, 8, 4, 7);
            
            int result = arr.stream()
                    .sorted()
                    .map(n->n*2)
                    .reduce(0, (c,e)->c+e);
                  //.reduce(0, Integer::sum); can be written as this using Lambda Expression
            
            System.out.println(result);
      }
}
