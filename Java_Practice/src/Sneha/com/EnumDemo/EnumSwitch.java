package Sneha.com.EnumDemo;

public class EnumSwitch {
      
      public static void main(String[] args){
            
            Day d = Day.MONDAY;
            
            String day = switch (d){
                  case MONDAY -> "Monday";
                  case TUESDAY -> "Tuesday";
                  default -> "Other days";
            };
            
            System.out.println(day);
      }
}
