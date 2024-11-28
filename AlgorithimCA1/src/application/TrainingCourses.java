package application;

import util.LinearNode;
import util.LinkedList;
import java.util.Scanner;

public class TrainingCourses {

    private Scanner sc;
    private LinkedList<Employee> employeeList;
    private Employee[] employees;

    public TrainingCourses() {
        sc = new Scanner(System.in);
        employeeList = new LinkedList<>();
        TrainingCourses tc = new TrainingCourses();
        tc.userEmployeeInput();
        tc.displayEmployeeDetails();
        tc.removeEmployee();
        tc.deleteEmployeesFromCourse();
        tc.awardCertificate();
        tc.displayAllEmployeeDetails();
    }

    public void userEmployeeInput() {
        int numEmployees;
        do {
            System.out.print("Enter amount of employees for course (Max 10): ");
            numEmployees = sc.nextInt();
            sc.nextLine();

            if (numEmployees < 1 || numEmployees > 10) {
                System.out.println("Number of employees must be between 1 - 10. Input again.");
                try {
            		Thread.sleep(500);
            	} catch (InterruptedException e) {
            		// TODO Auto-generated catch block
            		e.printStackTrace();
            	}
            }
        } while (numEmployees < 1 || numEmployees > 10);

        employees = new Employee[numEmployees];
        
        String employeeNum, employeeName, course;	
        int experience;

        System.out.println("\n====================================================");
        System.out.println("Enter employee details:");

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\n--- Employee " + (i + 1) + " ---");

            System.out.print("Employee Number: ");
            employeeNum = sc.nextLine();

            System.out.print("Name: ");
            employeeName = sc.nextLine();

            System.out.print("Experience: ");
            experience = sc.nextInt();
            sc.nextLine();

            System.out.print("Course Name: ");
            course = sc.nextLine();

            employees[i] = new Employee(employeeNum, employeeName, experience, course);
        }
    }

    public void displayEmployeeDetails() {
        System.out.println("\n====================================================");
        System.out.println("Employees have been added to the list. Now choose their positions.");
        try {
    		Thread.sleep(500);
    	} catch (InterruptedException e) {
    		// TODO Auto-generated catch block
    		e.printStackTrace();
    	}

        for (Employee employee : employees) {
            System.out.println(employee);

            int position;
            do {
                System.out.print("Enter the position for employee (1 to " + (employeeList.size() + 1) + "): ");
                position = sc.nextInt();
                sc.nextLine();

                if (position < 1 || position > employeeList.size() + 1) {
                    System.out.println("Invalid position. Please try again.");
                }
            } while (position < 1 || position > employeeList.size() + 1);

            employeeList.add(employee, position);
        }
    }

    public void removeEmployee() {
    	String removeOption, employeeNumber;	
        System.out.println("\n====================================================");
        System.out.println("Do you want to remove an employee? (yes/no): ");
        removeOption = sc.nextLine().toLowerCase();

        if (removeOption.equals("yes")) {
            System.out.print("Enter the employee's number you wish to remove: ");
            employeeNumber = sc.nextLine();

            Employee tempEmployee = new Employee(employeeNumber, "", 0, "");
            Employee removedEmployee = employeeList.remove(tempEmployee);

            if (removedEmployee == null) {
                System.out.println("\nNo employee found with this employee number " + employeeNumber + ".");
            } else {
                System.out.println("\nEmployee with the employee number " + employeeNumber + " has been removed.");
            }
        }
    }

    public void displayAllEmployeeDetails() {
    	for (LinearNode<Employee> current = employeeList.getFront(); current!= null; current = current.getNext())
    	{
    		System.out.println(current.getElement().toString());
    		try {
    			Thread.sleep(500);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    	}
    	}
    }
    	

    public void deleteEmployeesFromCourse() {
    	
    	String deleteOption, courseName;
    	
        System.out.println("\n====================================================");
        System.out.println("Do you want to delete employees from a certain course? (yes/no): ");
        deleteOption = sc.nextLine().toLowerCase();

        if (deleteOption.equals("yes")) {
            System.out.print("Enter the course name to delete employees from: ");
            courseName = sc.nextLine();

            int removedCount = employeeList.removeEmployeesFromCourse(courseName);
            if (removedCount > 0) {
                System.out.println("\n" + removedCount + " employee(s) removed from the course: " + courseName);
            } else {
                System.out.println("\nNo employees found on the course: " + courseName);
            }
        }
    }

    public void awardCertificate() {
    	String awardByCourseAndNameOption, employeeName, courseName;
        System.out.print("\nWould you like to award a certificate to an employee by course and name? (yes/no): ");
        awardByCourseAndNameOption = sc.nextLine().toLowerCase();

        if (awardByCourseAndNameOption.equals("yes")) {
            System.out.print("Enter the course name: ");
            courseName = sc.nextLine();

            System.out.print("Enter the employee's name: ");
            employeeName = sc.nextLine();

            boolean success = employeeList.awardCert(courseName, employeeName);

            if (success) {
                System.out.println("Certificate successfully awarded to " + employeeName + " in course " + courseName + ".");
            } else {
                System.out.println("No certificate awarded. Employee not found.");
            }
        }
    }

    

    public static void main(String[] args) {
        new TrainingCourses();
        
    }
}

