package sms.service;

import sms.entity.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeService {
    void listEmployees();

    List<Employee> searchEmployeesByDepartment();

    Employee searchEmployeeById();

    List<Employee> searchEmployeesByFirstName();

    void exit();

    void addEmployee();

    void editEmployee();

    void fireEmployee();
}
