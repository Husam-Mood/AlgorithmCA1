package application;

import java.util.Scanner;

public class TrainingCourses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.print("Enter the number of employees you wish to input (max is 10): ");
        int numEmployees = scanner.nextInt();
        scanner.nextLine(); 
        if (numEmployees < 1 || numEmployees > 10) {
            System.out.println("Error: Number of employees must be between 1 and 10.");
            return;
        }

        Employee[] employees = new Employee[numEmployees];

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");
            System.out.print("Employee Number: ");
            String empNumber = scanner.nextLine();
            System.out.print("Name: ");
            String empName = scanner.nextLine();
            System.out.print("Experience : ");
            int years = scanner.nextInt();
            scanner.nextLine(); 
            System.out.print("Course Name: ");
            String course = scanner.nextLine();

           
            employees[i] = new Employee(empNumber, empName, years, course);
        }

       
        System.out.println("\nEmployee Details:");
        for (Employee emp : employees) {
            emp.displayEmployeeDetails();
        }

        
    }
}
