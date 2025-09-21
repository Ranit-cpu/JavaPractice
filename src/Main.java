//Imports
//import Sneha.com.Collections.*; 

import java.util.*;

public class Main {
      public static void main(String[] args) {
            Stack<Integer> num = new Stack<>();
            num.push(50);
            num.push(60);
            num.push(5);
            num.push(45);
            num.push(78);
            
           // System.out.println(num);
            System.out.println(num.indexOf(45));         //indexOf(value) gives index in FIFO form starting from 0
            System.out.println(num.search(50));       // search gives index in LIFO form starting from 1
            System.out.println(num.peek());              // returns last inserted value
            System.out.println(num.get(3));     //get(index) returns value at the index in FIFO starting from 0
            System.out.println(num);
      }
}
