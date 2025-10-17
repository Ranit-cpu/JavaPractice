package Sneha.com.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo2 {
    
    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(9,2,8,4,7);

        Stream<Integer> data = nums.stream();
//        for (int n: nums) {
//            System.out.println(n*2);
//        }

        //using Stream map
        Stream<Integer> mappedData = data.map(n->n*2);
        mappedData.forEach(System.out::println);

        System.out.println("---------");

        //2nd Approach
        Stream<Integer> data2 = nums.stream().map(n->n*2);
        data2.forEach(System.out::println);
        
        System.out.println("---------");
        
        //3rd Approach
        nums.stream()
                .sorted()
                .map(n->n*2)
                .forEach(System.out::println);
    }
}
