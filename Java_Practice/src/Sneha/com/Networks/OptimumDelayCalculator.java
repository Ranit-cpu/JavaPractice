package Sneha.com.Networks;

import java.io.FileWriter;
import java.io.IOException;

public class OptimumDelayCalculator {
      // Constants
      private static final double CHANNEL_CAPACITY = 100e9; // 100 Gbps in bits per second
      private static final double PROPAGATION_SPEED = 2e8; // Optical fiber speed in meters per second
      
      public static void main(String[] args) {
            // Define frame sizes (1000 to 1,000,000 bits)
            int[] frameSizes = {1000, 5000, 10000, 50000, 100000, 500000, 1000000};
            // Define physical distances (100m to 5000km)
            int[] distances = {100, 500, 1000, 5000, 10000, 50000, 100000, 5000000};
            
            try (FileWriter writer = new FileWriter("optimum_delay_data.csv")) {
                  // Writing CSV header with table formatting
                  writer.append("Frame Size (bits), Distance (meters), Transmission Delay (ms), Propagation Delay (ms), Total Delay (ms)\n");
                  
                  for (int frameSize : frameSizes) {
                        for (int distance : distances) {
                              // Calculate transmission delay
                              double transmissionDelay = (double) frameSize / CHANNEL_CAPACITY * 1000; // Convert to ms
                              // Calculate propagation delay
                              double propagationDelay = (double) distance / PROPAGATION_SPEED * 1000; // Convert to ms
                              // Compute total delay
                              double totalDelay = transmissionDelay + propagationDelay;
                              
                              // Writing values to CSV in table format
                              writer.append(String.format("%d, %d, %.6f, %.6f, %.6f\n", frameSize, distance, transmissionDelay, propagationDelay, totalDelay));
                        }
                  }
                  System.out.println("CSV file generated successfully: optimum_delay_data.csv");
            } catch (IOException e) {
                  e.printStackTrace();
            }
      }
}
