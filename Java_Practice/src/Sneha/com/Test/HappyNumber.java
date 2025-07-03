package Sneha.com.Test;

import java.util.HashSet;
import java.util.Scanner;

public class HappyNumber {

      
      private static boolean isHappy(int n){
            
            HashSet<Integer> set = new HashSet<>();
            
            while(n != 1 && !set.contains(n)){
                  set.add(n);
                  n = sumOfSquares(n);
            }
            
            return n == 1;
      }
      
      private static int sumOfSquares(int n){
            
            int sum = 0;
            
            while(n > 0){
                  
                  sum += (n%10)*(n%10);
                  n /=10;
            }
            
            return sum;
      }
      
      
      public static void main(String[] args){
            
            Scanner sc = new Scanner(System.in);
            
            System.out.print("Enter a number to check Happy or not = ");
            int n = sc.nextInt();
            
            if(isHappy(n)){
                  System.out.println(n+" is a Happy Number.");
            }else{
                  System.out.println(n+" is not a Happy Number.");
            }
      }
}
