package Sneha.com.Test;

import java.util.Scanner;

public class MatrixMultiplication {
      
      public static void main(String[] args) {
            
            Scanner sc = new Scanner(System.in);
            
            // Input dimensions for matrix A
            System.out.print("Enter rows and columns of matrix A (n m): ");
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            // Input matrix A
            int[][] A = new int[n][m];
            System.out.println("Enter elements of matrix A:");
            for (int i = 0; i < n; i++)
                  for (int j = 0; j < m; j++)
                        A[i][j] = sc.nextInt();
            
            // Input dimensions for matrix B
            System.out.print("Enter rows and columns of matrix B (p q): ");
            int p = sc.nextInt();
            int q = sc.nextInt();
            
            // Check if multiplication is possible
            if (m != p) {
                  System.out.println("Matrix multiplication not possible (columns of A != rows of B).");
                  return;
            }
            
            // Input matrix B
            int[][] B = new int[p][q];
            System.out.println("Enter elements of matrix B:");
            for (int i = 0; i < p; i++)
                  for (int j = 0; j < q; j++)
                        B[i][j] = sc.nextInt();
            
            // Resultant matrix of size n x q
            int[][] result = new int[n][q];
            
            // Matrix multiplication logic
            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < q; j++) {
                        for (int k = 0; k < m; k++) {
                              result[i][j] += A[i][k] * B[k][j];
                        }
                  }
            }
            
            // Print the result matrix
            System.out.println("Resultant Matrix of size " + n + " x " + q + ":");
            for (int i = 0; i < n; i++) {
                  for (int j = 0; j < q; j++) {
                        System.out.print(result[i][j] + " ");
                  }
                  System.out.println();
            }
            
            sc.close();
      }
}
