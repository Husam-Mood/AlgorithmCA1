package application;

import util.LinkedList;
import java.util.Scanner;

public class TrainingCourses {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Employee> employeeList = new LinkedList<>();

        int numEmployees;
        do {
            System.out.print("====================================================\n");
            System.out.print("Enter the number of employees you wish to input (max10): ");
            numEmployees = sc.nextInt();
            sc.nextLine();

            if (numEmployees < 1 || numEmployees > 10) {
                System.out.println("Number of emloyees have to be inbetween 1-10:");
                try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
                
				 
            }
        } while (numEmployees < 1 || numEmployees > 10);
        
        String employeeNumb,employeeName, course;
        int experience,position;

        for (int i = 0; i < numEmployees; i++) {
            boolean valid = false;

            while (!valid) {
                System.out.println("\n====================================================");
                System.out.println("Enter details for Employee " + (i + 1) + ":");
                try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

                System.out.print("Employee Number: ");
                employeeNumb = sc.nextLine();
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

                System.out.print("Where do you want employee to be in the list (1 to " + (employeeList.size() + 1) + "): ");
                position = sc.nextInt();
                sc.nextLine();
                try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

                boolean experienceValid = experience >= 5;
                
                if (!experienceValid) {
                    System.out.println("Error: Employee needs more than 4 years of experience for course:");
                    System.out.print("Do you wish to renter details for employees? (yes/no): ");
                    String response = sc.nextLine().toLowerCase();
                    try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

                    if (response.equals("no")) {
                        System.out.println("Skipping this employee.");
                        valid = true;
                    } else {
                        System.out.println("Re-enter the details for this employee.");
                        try {
    						Thread.sleep(500);
    					} catch (InterruptedException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
                    }
                } else {
                    if (!course.startsWith("FOOD")) {
                        System.out.println("Error: Course name must start with 'FOOD'. Course will be set to 'ERROR'.");
                        course = "ERROR";
                        try {
    						Thread.sleep(500);
    					} catch (InterruptedException e) {
    						// TODO Auto-generated catch block
    						e.printStackTrace();
    					}
                    }

                 Employee emp = new Employee(employeeNumb, employeeName, experience, course);

                 employeeList.add(emp, position);

                 if (position >= 1 && position <= employeeList.size() + 1) {
                     valid = true;
                     System.out.println("Employee added successfully.");
                 } else {
                     System.out.println("Invalid position. Employee not added.");
                 }

                }
                System.out.println("====================================================");
            }
        }

        System.out.println("\n====================================================");
        System.out.println("Employee Details:");
        System.out.println(employeeList.toString());
        System.out.println("====================================================");
    }

   
}








