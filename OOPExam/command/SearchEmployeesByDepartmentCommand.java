package sms.command;

import sms.service.EmployeeService;

/**
 * Represents a command to search for employees by department.
 * Executes the corresponding method in the provided EmployeeServicе
 */
public class SearchEmployeesByDepartmentCommand implements Command {
    private final EmployeeService employeeService;

    /**
     * Constructs a SearchEmployeesByDepartmentCommand object.
     *
     * @param employeeService The service responsible for employee data management.
     */
    public SearchEmployeesByDepartmentCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Executes the search operation for employees by department.
     */
    @Override
    public void execute() {
        employeeService.searchEmployeesByDepartment();
    }
}
