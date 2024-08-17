package sms.command;

import sms.service.EmployeeService;
/**
 * Represents a command to exit the employee data management system.
 * Executes the corresponding method in the provided EmployeeService.
 */
public class ExitCommand implements Command {
    private final EmployeeService employeeService;
    /**
     * Constructs an ExitCommand object.
     * @param employeeService The service responsible for employee data management.
     */
    public ExitCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    /**
     * Executes the operation to exit the system.
     */
    @Override
    public void execute() {
        employeeService.exit();
    }
}
