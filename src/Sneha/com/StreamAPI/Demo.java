package Sneha.com.StreamAPI;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args){
        List<Integer> nums = Arrays.asList(9,2,8,4,7);

        Stream<Integer> data = nums.stream();

//        nums.forEach(n-> System.out.print(n+" "));

        data.forEach(System.out::println);          // Can be used only once
        /*data.forEach(System.out::println);        if used for the second time it will throw exception*/
    }
}
