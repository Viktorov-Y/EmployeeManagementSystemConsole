package sms.command;

import sms.service.EmployeeService;
/**
 * Represents a command to search for an employee by their ID.
 * Executes the corresponding method in the provided EmployeeService.
 */
public class SearchEmployeeByIdCommand implements Command {
    private final EmployeeService employeeService;
    /**
     * Constructs a SearchEmployeeByIdCommand object.
     * @param employeeService The service responsible for employee data management.
     */
    public SearchEmployeeByIdCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    /**
     * Executes the operation to search for an employee by their ID.
     */
    @Override
    public void execute() {
        employeeService.searchEmployeeById();
    }
}
