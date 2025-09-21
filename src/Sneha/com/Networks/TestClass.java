package Sneha.com.Networks;


import java.io.BufferedReader;
import java.io.InputStreamReader;

class TestClass {
      public static void main(String args[] ) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String name = br.readLine();
            for(int i = 0; i < 5; i++) {
                  System.out.println(name);
            }
      }
}