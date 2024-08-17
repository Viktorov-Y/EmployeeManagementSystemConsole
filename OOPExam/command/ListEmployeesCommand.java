package sms.command;

import sms.entity.Employee;
import sms.service.EmployeeService;
/**
 * Represents a command to display information for all active employees.
 * Executes the corresponding method in the provided EmployeeService.
 */
public class ListEmployeesCommand implements Command {
    private final EmployeeService service;
    /**
     * Constructs a ListEmployeesCommand object.
     * @param service The service responsible for employee data management.
     */
    public ListEmployeesCommand(EmployeeService service) {
        this.service = service;
    }
    /**
     * Executes the operation to list all active employees.
     */
    @Override
    public void execute() {
service.listEmployees();
    }
}
