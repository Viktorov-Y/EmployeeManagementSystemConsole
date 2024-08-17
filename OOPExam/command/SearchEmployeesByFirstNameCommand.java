package sms.command;

import sms.service.EmployeeService;
/**
 * Represents a command to search for employees by their first name
 * Executes the corresponding method in the provided EmployeeService.
 */
public class SearchEmployeesByFirstNameCommand implements Command{
    private final EmployeeService employeeService;

    /**
     * Constructs a SearchEmployeesByFirstNameCommand object.
     * @param employeeService The service responsible for employee data management.
     */
    public SearchEmployeesByFirstNameCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    /**
     * Executes the operation to search for employees by their first name.
     */
    @Override
    public void execute() {
        employeeService.searchEmployeesByFirstName();
    }
}
