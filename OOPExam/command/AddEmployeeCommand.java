package sms.command;

import sms.entity.Employee;
import sms.service.EmployeeService;
/**
 * Represents a command to add a new employee.
 * Executes the corresponding method in the provided EmployeeService
 */
public class AddEmployeeCommand implements Command {
    private final EmployeeService service;
    /**
     * Constructs an AddEmployeeCommand object.
     * @param service The service responsible for employee data management.
     */
    public AddEmployeeCommand(EmployeeService service) {
        this.service = service;
   }

    /**
     * Executes the operation to add a new employee.
     */
    @Override
    public void execute() {
        service.addEmployee();
    }
}

