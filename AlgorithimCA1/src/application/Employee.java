package application;

public class Employee {
    private String employeeNumber;
    private String name;
    private int experience;
    private String courseName;

    public Employee(String employeeNumber, String name, int experience, String courseName) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.experience = experience; 
        this.courseName = courseName;
    }

    public Employee() {
        this.employeeNumber = "";
        this.name = "";
        this.experience = 0;
        this.courseName = "ERROR";
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

    public int getExperience() {
        return experience;
    }

    public void getExperience(int experience) {
        this.experience = experience;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
 
    public boolean employeeSame(String employeeNumber) {
        return this.employeeNumber.equals(employeeNumber);
    }
    
    @Override
    public String toString() {
        return "Employee Number: " + employeeNumber +
               ", Name: " + name +
               ", Experience " + experience +
               ", Course Name: " + courseName;
    }
}

