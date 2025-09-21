package Sneha.com.examples;

public class LongestSub
{
      public int getLongestSubarray(int[] arr, int k)
      {
            int longest = 0;
            
            for (int i = 0; i < arr.length; i++){
                  for (int j = i; j < arr.length; j++){
                        int sum = 0;
                        for(int K = i; K <= j;K++){
                              sum += arr[k];
                        }
                        if(sum == k){
                              longest = Math.max(longest, j - i + 1);
                        }
                  }
            }
            
            return longest;
      }
      

}
