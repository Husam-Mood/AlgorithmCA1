package application;

public class Employee {
    private String employeeNumber;
    private String name;
    private int experience;
    private String courseName;
    private boolean certified; 

    public Employee(String employeeNumber, String name, int experience, String courseName) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.experience = experience; 
        this.courseName = courseName;
        this.certified = false; 
    }

    public Employee() {
        this.employeeNumber = "";
        this.name = "";
        this.experience = 0;
        this.courseName = "ERROR";
        this.certified = false;
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
 
    public void setExperience(int experience) {
        if (experience < 5) {
            System.out.println("Employee must have 5 years of experience.");
            this.experience = 0; 
        } else {
            this.experience = experience;
        }
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        if (!courseName.startsWith("FOOD")) {
            System.out.println("Error: Course name must start with 'FOOD'. Course name will be set to 'ERROR'.");
            this.courseName = "ERROR";
        } else {
            this.courseName = courseName;
        }
    }

    public boolean isCertified() {
        return certified;
    }

    public void setCertified(boolean certified) {
        this.certified = certified;
    }

 // Award certification to the employee
    public void awardCertification() {
        if (!certified) {
            this.certified = true;
            System.out.println("Certification awarded to: " + name);
        } else {
            System.out.println("Employee " + name + " is already certified.");
        }
    }


    public boolean employeeSame(String employeeNumber) {
        return this.employeeNumber.equals(employeeNumber);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee employee = (Employee) obj;
        return employeeNumber != null && employeeNumber.equals(employee.employeeNumber);
    }

    @Override
    public String toString() {
        return "Employee Number: " + employeeNumber +
               ", Name: " + name +
               ", Experience: " + experience +
               ", Course Name: " + courseName +
               ", Certified: " + certified ;
    }
}


