package com.jsp.hibernate.employeedb;

import java.util.Scanner;

import com.jsp.hibernate.employeedb.dao.EmployeeDAD;

public class App 
{
    public static void main( String[] args )
    {
        Scanner  sc  = new Scanner(System.in);
        System.out.println("Enter the choice ");
        int choice = sc.nextInt();
        while (true) {
        	  switch (choice) {
      		case 1:
      			EmployeeDAD.addEpmloyee();
      			break;

      		default:
      			break;
      		}
		}
      
    }
}
