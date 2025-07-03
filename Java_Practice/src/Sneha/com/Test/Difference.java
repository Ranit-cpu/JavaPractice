package Sneha.com.Test;

import java.util.HashSet;

public class Difference {
      
      public static void main(String[] args){
            int[] arr = {1, 5, 3, 4, 2};
            int K = 2;
            
            findPairsWithDifference(arr, K);
      }
      
      private static void findPairsWithDifference(int[] arr, int k){
            
            HashSet<Integer> set = new HashSet<>();
            
            
            // Adding all elements to set
            for(int i : arr){
                  set.add(i);
            }
            
            System.out.println("Pairs with absolute difference " + k + ":");
            
            
            for(int n: arr){
                  if(set.contains(n + k)){
                        System.out.println("["+n+", "+(n+k)+"]");
                  } else if (set.contains(n - k)) {
                        System.out.println("["+n+", "+(n-k)+"]");
                  }
            }
      }
}
