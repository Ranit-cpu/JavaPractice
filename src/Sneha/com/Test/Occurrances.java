package Sneha.com.Test;

public class Occurrances {
      
      // Function to count how many times K occurs in str
      public static int countOccurrences(String str, String K) {
            int count = 0;        // Stores total occurrences
            int index = 0;        // Current position in str
            
            // Search while K is found in str starting at index
            while ((index = str.indexOf(K, index)) != -1) {
                  count++;          // Found one occurrence
                  index ++;       // Move to next character (allows overlap)
            }
            
            return count;
      }
      
      public static void main(String[] args) {
            String str = "ababcababcab";  // Main string
            String K = "ab";              // Substring to find
            
            int occurrences = countOccurrences(str, K);  // Call function
            System.out.println("Count of '" + K + "' in the string: " + occurrences);
      }
}
