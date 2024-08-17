package sms.command;

import sms.service.EmployeeService;
/**
 * Represents a command to edit an existing employee's details.
 * Executes the corresponding method in the provided EmployeeServic.
 */
public class EditEmployeeCommand implements Command {
    private EmployeeService employeeService;
    /**
     * Constructs an EditEmployeeCommandobject.
     * @param employeeService The service responsible for employee data management.
     */
    public EditEmployeeCommand(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    /**
     * Executes the operation to edit an employee's details.
     */
    public EditEmployeeCommand() {
        employeeService.editEmployee();
    }

    @Override
    public void execute() {
        employeeService.editEmployee();
    }
}
