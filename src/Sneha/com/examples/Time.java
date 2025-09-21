package Sneha.com.examples;

public class Time {
      
      private final int hour;
      private final int minute;
      private final int second;
      
      public Time(int hour, int minute, int second) {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
      }
      
      public void add(Time time) {
            
            int totalseconds = this.second + time.second;
            int totalminutes = this.minute + time.minute+(totalseconds / 60);
            int totalhours = this.hour + time.hour+(totalminutes / 60);
            
            totalseconds = totalseconds % 60;
            totalminutes = totalminutes % 60;
            
            System.out.println("Added Time = "+totalhours + ":" + totalminutes + ":" + totalseconds);
      }
      
      public void display()
      {
            System.out.println(this.hour+":"+this.minute+":"+this.second);
      }
}
