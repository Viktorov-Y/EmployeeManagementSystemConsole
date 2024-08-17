package sms.entity;

/**
 * The Employee class represents an employee entity with various attributes.
  */
public class Employee {
    private int id;
    private String firstName;
    private String department;
    private String role;
    private double salary;
    private boolean isFired;
    /**
     * Constructs an Employee object with specified attributes.
     * @param id         The unique identifier for the employee.
     * @param firstName  The first name of the employee.
     * @param lastName   The last name of the employee.
     * @param department The department in which the employee works.
     * @param role       The role or position of the employee.
     * @param salary     The salary of the employee.
     */
    public Employee(int id,  String firstName,
                    String department, String role, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.department = department;
        this.role = role;
        this.salary = salary;
        this.isFired = false;
    }
    /**
     * Default constructor for the Employee class.
     */
    public Employee() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public boolean isFired() {
        return isFired;
    }

    public void setFired(boolean fired) {
        isFired = fired;
    }
    /**
     * Returns a string representation of the employee, including relevant details.
     * @return A formatted string containing employee information.
     */
    @Override
    public String toString() {
        return String.join( ", ", String.valueOf(id),firstName, department, role, String.valueOf(salary));    }
}
