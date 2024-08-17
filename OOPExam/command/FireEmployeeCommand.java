package sms.command;

import sms.entity.Employee;
import sms.service.EmployeeService;
/**
 * Represents a command to flag an employee as "fired" and remove them from the system.
 * Executes the corresponding method in the provided EmployeeService.
 */
public class FireEmployeeCommand implements Command{
    private final EmployeeService service;
    /**
     * Constructs a FireEmployeeCommand object.
     * @param service The service responsible for employee data management.
     */
    public FireEmployeeCommand(EmployeeService service) {
        this.service = service;
    }
    /**
     * Executes the operation to fire an employee.
     */
    @Override
    public   void execute() {
service.fireEmployee();
    }
}
