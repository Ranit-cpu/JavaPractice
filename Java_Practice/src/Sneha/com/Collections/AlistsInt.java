package Sneha.com.Collections;

//ArrayLists Strings
import java.util.ArrayList;
import java.util.Random;

public class AlistsInt
{
      public static void main(String[] args)
      {
            Random rand = new Random();
            
            ArrayList<Integer> list = new ArrayList<>();
            
            for(int i = 0 ; i < 5; i++){
                  list.add(rand.nextInt(100));
            }
            
            System.out.println(list);
      }
}
