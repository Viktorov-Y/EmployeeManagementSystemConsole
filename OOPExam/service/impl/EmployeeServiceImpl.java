package sms.service.impl;

import sms.entity.Employee;
import sms.service.EmployeeService;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static sms.util.Constants.*;

/**
 * The EmployeeServiceImpl class implements the `EmployeeService` interface
 * and provides functionality for managing employee data.
 * It handles loading and saving employee information from/to a file.
 */
public class EmployeeServiceImpl implements EmployeeService {
    public static final String FILE_PATH = "C:\\untitled1\\Data\\EmployeeToWrite";
    private List<Employee> employees;
    private File writeFile = new File(FILE_PATH);

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
        loadEmployeesFromFile();
    }
    /**
     * Saves the list of employees to the file.
     * @param employees The list of employees to be saved.
     */
    private void saveEmployeesToFile(List<Employee> employees) {
        try (FileWriter writer = new FileWriter(writeFile, false)) {
            for (Employee employee : employees) {
                String employeeData = employee.toString() + System.lineSeparator();
                writer.write(employeeData);
            }
            System.out.println(DATA_SAVED);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Loads employee data from the file and populates the list.
     */
    private void loadEmployeesFromFile() {
        try (Scanner scanner = new Scanner(writeFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] employeeData = line.trim().split(",");
                if (employeeData.length == 5) {
                    int id = Integer.parseInt(employeeData[0]);
//                    String firstName = employeeData[1];
                    String name = employeeData[1];
                    String department = employeeData[2];
                    String role = employeeData[3];
                    double salary = Double.parseDouble(employeeData[4]);
                    Employee employee = new Employee(id, name, department, role, salary);
                    employees.add(employee);
                } else {
                    System.out.println(INVALID_DATA_FORMAT + line);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    /**
     * Displays information for all active employees.
     * If no active employees are found, a corresponding message is displayed.
     */
    @Override
    public void listEmployees() {
        System.out.println(ALL_ACTIVE_EMPLOYEES);
        boolean hasActiveEmployees = false;
        for (Employee employee : employees) {
            if (!employee.isFired()) {
                System.out.println(employee);
                hasActiveEmployees = true;
            }
        }
        if (!hasActiveEmployees) {
            System.out.println(NO_ACTIVE_EMPLOYEES_FOUND);
        }
    }
    /**
     * Searches for employees by department
     * @return A list of found employees in the specified department,
     *         excluding those who have been fired, or an empty list if none found.
     */
    @Override
    public List<Employee> searchEmployeesByDepartment() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ENTER_DEPARTMENT);
        String department = sc.nextLine();
        List<Employee> employeesByDepartment = new ArrayList<>();
        for (Employee employee : employees) {
            String em=employee.getDepartment().trim();
            if (em.equalsIgnoreCase(department)) {
                employeesByDepartment.add(employee);
            }
        }
        if (employeesByDepartment.isEmpty()) {
            System.out.println(NO_EMPLOYEES_IN_THIS_DEPARTMENT);
        } else {
            for (Employee employee : employeesByDepartment) {
                if (!employee.isFired()) {
                    System.out.println(employee);
                }
            }
        }
        return employeesByDepartment;
    }
    /**
     * Searches for an employee by ID.
     * @return The found employee or null if not found.
     */
    @Override
    public Employee searchEmployeeById() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ENTER_EMPLOYEE_ID);
        int id = Integer.parseInt(sc.nextLine());
        Employee employee = employees.stream().filter(e -> e.getId() == id)
                .findFirst().orElse(null);
        if (employee == null || employee.isFired()) {
            System.out.println(NO_EMPLOYEE_WITH_GIVEN_ID);
        } else {
            System.out.println(employee);
        }
        return employee;
    }
    /**
     * Searches for employees by first name.
     * @return A list of found employees or an empty list if none found.
     */
    @Override
    public List<Employee> searchEmployeesByFirstName() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ENTER_FIRST_NAME);
        String firstName = sc.nextLine();
        List<Employee>employeesByFirstName=new ArrayList<>();
         for (Employee employee : employees) {
            String[] firstAndLastName=employee.getFirstName().trim().split(" ");
            if (firstAndLastName[0].trim().equalsIgnoreCase(firstName)) {
                employeesByFirstName.add(employee);
            }
        }
        if (!employeesByFirstName.isEmpty()) {
            for (Employee foundEmployee : employeesByFirstName) {
                if (!foundEmployee.isFired()) {
                    System.out.println(foundEmployee);
                }
            }
        } else {
            System.out.println(NO_EMPLOYEE_FOUND_WITH_GIVEN_NAME);
        }
        return employeesByFirstName;
    }
    /**
     * Exits the employee data management system.
     * Saves the current employee data to the file.
     */
    @Override
    public void exit() {
        saveEmployeesToFile(employees);
        System.out.println(GOODBYE);
        System.exit(0);
    }
    /**
     * Adds a new employee to the system.
     * Prompts the user for employee details
     */
    @Override
    public void addEmployee() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println(ENTER_EMPLOYEE_ID_TO_ADD);
            int id = Integer.parseInt(sc.nextLine());
            System.out.println(ENTER_FIRST_NAME);
            String firstName = sc.nextLine();
            if (!firstName.matches("^[a-zA-Z]+$")) {
                throw new IllegalArgumentException(PLEASE_ENTER_LETTERS_ONLY);
            }
            System.out.println(ENTER_LAST_NAME);
            String lastName = sc.nextLine();
            if (!lastName.matches("^[a-zA-Z]+$")) {
                throw new IllegalArgumentException(PLEASE_ENTER_LETTERS_ONLY);
            }
            System.out.println(ENTER_DEPARTMENT);
            String department = sc.nextLine();
            System.out.println(ENTER_ROLE);
            String role = sc.nextLine();
            System.out.println(ENTER_SALARY);
            double salary = Double.parseDouble(sc.nextLine());
            String fullName=firstName+" "+lastName;
            Employee employee = new Employee(id, fullName, department, role, salary);
            employees.add(employee);
            System.out.println(SUCCESSFULLY_ADDED_NEW_EMPLOYEE);
        } catch (NumberFormatException e) {
            System.out.println(PLEASE_ENTER_VALID_NUMERIC_VALUES_FOR_ID_AND_SALARY);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * Edits an existing employee's details.
     * Prompts the user for updated information
     */
    @Override
    public void editEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ENTER_EMPLOYEE_ID_TO_EDIT);
        try {
            int id = Integer.parseInt(sc.nextLine());
            Employee employeeToEdit = findEmployeeById(id);
            if (employeeToEdit != null) {
                System.out.println(ENTER_NEW_FIRST_NAME);
                String newFirstName = sc.nextLine();
                System.out.println(ENTER_NEW_LAST_NAME);
                String newLastName = sc.nextLine();
                System.out.println(ENTER_NEW_DEPARTMENT);
                String newDepartment = sc.nextLine();
                System.out.println(ENTER_NEW_ROLE);
                String newRole = sc.nextLine();
                System.out.println(ENTER_NEW_SALARY);
                double newSalary = Double.parseDouble(sc.nextLine());
                employeeToEdit.setFirstName(newFirstName+" "+newLastName);
                employeeToEdit.setDepartment(newDepartment);
                employeeToEdit.setRole(newRole);
                employeeToEdit.setSalary(newSalary);
                System.out.println(EMPLOYEE_UPDATED_SUCCESSFULLY);
            } else {
                System.out.println(EMPLOYEE_NOT_FOUND);
            }
        } catch (NumberFormatException e) {
            System.out.println(INVALID_INPUT_PLEASE_ENTER_A_VALID_NUMERIC_ID);
        }
    }
    /**
     * Flags an employee as "fired" and removes them from the system.
     * Prompts the user for the employee's ID.
     */
    @Override
    public void fireEmployee() {
        Scanner sc = new Scanner(System.in);
        System.out.println(ENTER_EMPLOYEE_ID_TO_FIRE);
        int id = Integer.parseInt(sc.nextLine());
        Employee employeeToFire = findEmployeeById(id);
        if (employeeToFire != null) {
            employeeToFire.setFired(true);
            employees.remove(employeeToFire);
            System.out.println(EMPLOYEE_FIRED_SUCCESSFULLY);
        } else {
            System.out.println(EMPLOYEE_NOT_FOUND);
        }
    }
    /**
     * Finds an employee by their ID.
     * @param id The ID of the employee to search for.
     * @return The found employee or null if not found.
     */
    private Employee findEmployeeById(int id) {
        for (Employee employee : employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
