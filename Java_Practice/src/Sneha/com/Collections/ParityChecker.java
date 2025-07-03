package Sneha.com.Collections;

import java.util.Scanner;

public class ParityChecker {
      
      // Method to calculate parity bit
      public static int calculateParityBit(String data, String parityType)
      {
            int count = 0;
            for (char bit : data.toCharArray())
            {
                  if (bit == '1') count++;
            }
            return (parityType.equals("even")) ? (count % 2 == 0 ? 0 : 1) : (count % 2 == 0 ? 1 : 0);
      }
      
      public static void main(String[] args)
      {
            Scanner scanner = new Scanner(System.in);
            
            // Sender Side
            System.out.print("Enter (n-1) bit data: ");
            String data = scanner.next();
            
            System.out.print("Enter parity type (even/odd): ");
            String parityType = scanner.next();
            
            int parityBit = calculateParityBit(data, parityType);
            String transmittedData = data + parityBit;
            
            System.out.println("Transmitted data (including parity bit): " + transmittedData);
            
            // Receiver Side
            System.out.print("Enter received n-bit data: ");
            String receivedData = scanner.next();
            
            System.out.print("Enter parity type used: ");
            String receivedParityType = scanner.next();
            
            int receivedParityBit = calculateParityBit(receivedData.substring(0, receivedData.length() - 1), receivedParityType);
            
            if (receivedParityBit == Character.getNumericValue(receivedData.charAt(receivedData.length() - 1))) {
                  System.out.println("No error detected. Correct data: " + receivedData.substring(0, receivedData.length() - 1));
            }
            else
            {
                  System.out.println("Error detected in the received data!");
            }
            
            scanner.close();
      }
}