package Sneha.com.examples;

import java.time.*;

public class Details
{
      private final String name;
      private  int salary;
      private final LocalDate hiredate;
      
      public Details(String name,int salary,LocalDate hiredate)
      {
            this.name=name;
            this.salary=salary;
            this.hiredate=hiredate;
      }
      
      private String getName()
      {
            return name;
      }
      private int getSalary()
      {
            return salary;
      }
      private int yearsOfService()
      {
            return (Period.between(hiredate,LocalDate.now()).getYears());
      }
      
      public void increse(int  inc){
            salary=salary+inc;
      }
      
      public void display(){
            System.out.println("Name of the Employee = "+this.getName());
            System.out.println("Salary of the Employee = "+this.getSalary());
            System.out.println("Years of service = "+this.yearsOfService());
      }
      
}
