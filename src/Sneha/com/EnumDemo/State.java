package Sneha.com.EnumDemo;

public enum State {
      
      SOLID("Solid"),
      LIQUID("Liquid"),
      GAS("Gas");
      
      private String s;
      
      private State(String s){
            System.out.println("Constructor called");
            this.s = s;
      }
      
      public String display(){
            return "The State is "+this.s;
      }
}
