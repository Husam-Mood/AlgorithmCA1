package application;

import util.LinearNode;
import util.LinkedList;
import java.util.Scanner;

public class TrainingCourses {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Employee> employeeList = new LinkedList<>();

        int numEmployees;
        
        do {
            System.out.print("Enter amouont of employees for course;(Max 10) ");
            numEmployees = sc.nextInt();
            sc.nextLine();
          
            

            if (numEmployees < 1 || numEmployees > 10) {
                System.out.println("Number of employees must be between 1 - 10.Input again.");
                try {
    				Thread.sleep(500);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
            }
        } while (numEmployees < 1 || numEmployees > 10);

        Employee[] employees = new Employee[numEmployees];
        int validEmployeeCount = 0;

        System.out.println("\n====================================================");
        System.out.println("Enter employee details:");
        
        String employeeNum, employeeName, course;
        int experience;

        for (int i = 0; i < numEmployees; i++) {
            System.out.println("\n--- Employee " + (i + 1) + " ---");

            System.out.print("Employee Number: ");
            employeeNum = sc.nextLine();
            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            System.out.print("Name: ");
            employeeName = sc.nextLine();
            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

            System.out.print("Experience: ");
            experience = sc.nextInt();
            sc.nextLine(); 
            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
            System.out.print("Course Name: ");
            course = sc.nextLine();
            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
           

            employees[validEmployeeCount++] = new Employee(employeeNum, employeeName, experience, course);
        }

        if (validEmployeeCount == 0) {
            System.out.println("\nNo valid employees entered. Exiting program.");
            try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
        }

        System.out.println("\n====================================================");
        System.out.println("Employees have been added to list. Now choose which position you want them on the list.");
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        for (int i = 0; i < validEmployeeCount; i++) {
            System.out.println("\n--- Employee " + (i + 1) + " Details ---");
            System.out.println(employees[i].toString());

            int position;
            do {
                System.out.print("Enter the position for employee (1 to " + (employeeList.size() + 1) + "): ");
                position = sc.nextInt();
                sc.nextLine(); 

                if (position < 1 || position > employeeList.size() + 1) {
                    System.out.println("Invalid position. Please try again.");
                }
            } while (position < 1 || position > employeeList.size() + 1);

            employeeList.add(employees[i], position);
        }

        
        String removeOption;

        System.out.println("\n====================================================");
        System.out.println("Employee Details:");
        System.out.println(employeeList.toString());

        System.out.println("\n====================================================");
        System.out.println("Do you want to remove an employee? (yes/no): ");
        removeOption = sc.nextLine().toLowerCase();
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String employeeNumber;
        
        if (removeOption.equals("yes")) {
            System.out.print("Enter the employees number you wish to remove: ");
            employeeNumber = sc.nextLine();
            try {
    			Thread.sleep(500);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

            Employee tempEmployee = new Employee(employeeNumber, "", 0, ""); 
            Employee removedEmployee = employeeList.remove(tempEmployee); 

            if (removedEmployee == null) {
                System.out.println("\nNo employee found with this employee number " + employeeNumber + ".");
            } else {
                System.out.println("\nEmployee with the employee number " + employeeNumber + " has been removed.");
            }
        }

        System.out.println("\n====================================================");
        employeeList.displayCourses();
        try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        String deleteOption,courseName;

        System.out.println("\n====================================================");
        System.out.println("Do you want to delete employees from a certain course? (yes/no): ");
        deleteOption = sc.nextLine().toLowerCase();

        if (deleteOption.equals("yes")) {
            System.out.print("Enter the course name which you want to delete the employees from. ");
            courseName = sc.nextLine();
            try {
    			Thread.sleep(500);
    		} catch (InterruptedException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}

            int removedCount = employeeList.removeEmployeesFromCourse(courseName);
            if (removedCount > 0) {
                System.out.println("\n" + removedCount + " employee/employees removed from the course: " + courseName);
                try {
        			Thread.sleep(500);
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
            } else {
                System.out.println("\nNo employees found on the course: " + courseName);
                try {
        			Thread.sleep(500);
        		} catch (InterruptedException e) {
        			// TODO Auto-generated catch block
        			e.printStackTrace();
        		}
            }
        }

        System.out.println("\n====================================================");
       
        //displayEmployees();
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
        
        System.out.print("\nWould you like to award a certificate to an employee by course and name? (yes/no): ");
        String awardByCourseAndNameOption = sc.nextLine().toLowerCase();

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
    
    

	
}

