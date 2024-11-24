package application;

public class Employee {
    private String employeeNumber;
    private String name;
    private int yearsWorking;
    private String courseName;

    // Constructors
    public Employee() {
        
    }

    public Employee(String employeeNumber, String name, int yearsWorking, String courseName) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        setYearsWorking(yearsWorking);
        setCourseName(courseName);   
    }


    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYearsWorking() {
        return yearsWorking;
    }

    public void setYearsWorking(int yearsWorking) {
        if (yearsWorking >= 5) {
            this.yearsWorking = yearsWorking;
        } else {
            System.out.println("Error: Employees must have at least 5 years of experience.");
            this.yearsWorking = 0; 
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (courseName.startsWith("FOOD")) {
            this.courseName = courseName;
        } else {
            System.out.println("Error: Course name must start with 'FOOD'. Setting course name to 'ERROR'.");
            this.courseName = "ERROR";
        }
    }

  
    public void displayEmployeeDetails() {
        System.out.println("Employee Number: " + employeeNumber);
        System.out.println("Name: " + name);
        System.out.println("Years Working: " + yearsWorking);
        System.out.println("Course Name: " + courseName);
        System.out.println("-----------------------");
    }

    
    public boolean isSameEmployee(Employee other) {
        return this.employeeNumber.equals(other.getEmployeeNumber());
    }
}

