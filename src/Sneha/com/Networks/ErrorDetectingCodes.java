package Sneha.com.Networks;

import java.util.*;

public class ErrorDetectingCodes {
      
      // 2-D Parity Checker
      public static void parityChecker(int nbits, int mbits) {
            int totalBits = nbits * mbits;
            String[][] dataStream = new String[nbits][mbits];
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Enter the 2-D data stream (" + nbits + "x" + mbits + "):");
            for (int i = 0; i < nbits; i++) {
                  for (int j = 0; j < mbits; j++) {
                        dataStream[i][j] = scanner.next();
                  }
            }
            
            // Row parity check
            String[] rowParity = new String[nbits];
            for (int i = 0; i < nbits; i++) {
                  rowParity[i] = calculateParity(dataStream[i]);
            }
            
            // Column parity check
            String[] colParity = new String[mbits];
            for (int j = 0; j < mbits; j++) {
                  String[] col = new String[nbits];
                  for (int i = 0; i < nbits; i++) {
                        col[i] = dataStream[i][j];
                  }
                  colParity[j] = calculateParity(col);
            }
            
            System.out.println("Transmitted data stream:");
            for (int i = 0; i < nbits; i++) {
                  for (int j = 0; j < mbits; j++) {
                        System.out.print(dataStream[i][j] + " ");
                  }
                  System.out.println("| " + rowParity[i]);
            }
            for(int j = 0; j < mbits; j++) {
                  System.out.print(colParity[j] + " ");
            }
            System.out.println();
            
            double efficiency = (double) (totalBits - (nbits + mbits)) / totalBits * 100;
            System.out.println("Efficiency: " + efficiency + "%");
      }
      
      // Helper function to calculate parity (even parity)
      private static String calculateParity(String[] bits) {
            int onesCount = 0;
            for (String bit : bits) {
                  onesCount += Integer.parseInt(bit);
            }
            return (onesCount % 2 == 0) ? "0" : "1";
      }
      
      // Checksum Implementation
      public static void checksum(int nbits, int mblock) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter " + nbits + " bits data stream (in binary):");
            String dataStream = scanner.next();
            
            int checksum = 0;
            for (int i = 0; i < dataStream.length(); i++) {
                  checksum += Character.getNumericValue(dataStream.charAt(i));
            }
            checksum = checksum % 2;
            
            System.out.println("Checksum value: " + checksum);
            
            double efficiency = (double) (nbits - mblock) / nbits * 100;
            System.out.println("Efficiency: " + efficiency + "%");
      }
      
      // CRC Implementation
      public static void crc(int kbits, int patternBits) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter " + kbits + " bits data stream (in binary):");
            String dataStream = scanner.next();
            
            System.out.println("Enter " + patternBits + " bits CRC pattern:");
            String crcPattern = scanner.next();
            
            int k = dataStream.length();
            
            String augmentedData = dataStream + "0".repeat(crcPattern.length() - 1);
            
            String remainder = crcCalculation(augmentedData, crcPattern);
            
            String transmittedData = dataStream + remainder;
            System.out.println("Transmitted data stream: " + transmittedData);
            
            double efficiency = (double) (kbits - crcPattern.length()) / kbits * 100;
            System.out.println("Efficiency: " + efficiency + "%");
      }
      
      // Helper function for CRC calculation
      private static String crcCalculation(String dataStream, String crcPattern) {
            String dividend = dataStream;
            int patternLength = crcPattern.length();
            while (dividend.length() >= patternLength) {
                  if (dividend.charAt(0) == '1') {
                        dividend = xor(dividend.substring(0, patternLength), crcPattern) + dividend.substring(patternLength);
                  } else {
                        dividend = dividend.substring(1);
                  }
            }
            return dividend.substring(0, crcPattern.length() - 1);
      }
      
      private static String xor(String a, String b) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < a.length(); i++) {
                  result.append(a.charAt(i) == b.charAt(i) ? '0' : '1');
            }
            return result.toString();
      }
      
      // Hamming Code Implementation
      public static void hammingCode(int nbits) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter " + nbits + " bits data stream (in binary):");
            String dataStream = scanner.next();
            
            int r = 0;
            while (Math.pow(2, r) < nbits + r + 1) {
                  r++;
            }
            
            StringBuilder transmittedData = new StringBuilder(dataStream);
            for (int i = 0; i < r; i++) {
                  transmittedData.insert((int) Math.pow(2, i) - 1, '0');
            }
            
            // Calculate the parity bits for Hamming code
            for (int i = 0; i < r; i++) {
                  int parityBitPos = (int) Math.pow(2, i) - 1;
                  transmittedData.setCharAt(parityBitPos, calculateParityForHamming(transmittedData.toString(), parityBitPos));
            }
            
            System.out.println("Transmitted data stream: " + transmittedData);
            double efficiency = (double) (nbits) / (nbits + r) * 100;
            System.out.println("Efficiency: " + efficiency + "%");
      }
      
      // Helper function for Hamming code parity bit calculation
      private static char calculateParityForHamming(String data, int pos) {
            int count = 0;
            int step = pos + 1; // The step size to move through the data stream for parity calculation
            for (int i = pos; i < data.length(); i += step) {
                  // For each parity bit, toggle the step size for the positions influenced by it
                  for (int j = i; j < Math.min(i + step, data.length()); j++) {
                        if (data.charAt(j) == '1') {
                              count++;
                        }
                  }
            }
            return count % 2 == 0 ? '0' : '1';
      }
      
      public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            
            System.out.println("Choose the error-detecting code:");
            System.out.println("1. 2-D Parity Checker");
            System.out.println("2. Checksum");
            System.out.println("3. CRC");
            System.out.println("4. Hamming Code");
            
            System.out.print("Enter your choice : ");
            int choice = scanner.nextInt();
            switch (choice) {
                  case 1:
                        System.out.print("Enter the number of bits per data block (n): ");
                        int nbits = scanner.nextInt();
                        System.out.print("Enter the number of bits per block (m): ");
                        int mbits = scanner.nextInt();
                        parityChecker(nbits, mbits);
                        break;
                  case 2:
                        System.out.print("Enter the number of bits in the data stream (n): ");
                        int nbitsChecksum = scanner.nextInt();
                        System.out.print("Enter the block size (m): ");
                        int mblock = scanner.nextInt();
                        checksum(nbitsChecksum, mblock);
                        break;
                  case 3:
                        System.out.print("Enter the number of bits in the data stream (k): ");
                        int kbits = scanner.nextInt();
                        System.out.print("Enter the CRC pattern length (n-k+1): ");
                        int patternBits = scanner.nextInt();
                        crc(kbits, patternBits);
                        break;
                  case 4:
                        System.out.print("Enter the number of bits in the data stream (n): ");
                        int nbitsHamming = scanner.nextInt();
                        hammingCode(nbitsHamming);
                        break;
                  default:
                        System.out.println("Invalid choice.");
            }
      }
}
