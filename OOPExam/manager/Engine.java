package sms.manager;

import sms.command.*;
import sms.service.EmployeeService;
import sms.service.impl.EmployeeServiceImpl;

import java.util.Scanner;

import static sms.util.Constants.INVALID_INPUT;

/**
 * Engine class manages the employee data management system.
 * It provides a menu interface for executing various commands related to employees.
 * Users can add, edit, fire, list, and search for employees using this class.
 */
public class Engine {
    private EmployeeManager employeeManager;
    private Scanner sc;
    /**
     * Constructs an Engine object.
     * Initializes the employee manager and scanner.
     */
    public Engine() {
        this.employeeManager = new EmployeeManager();//
        this.sc = new Scanner(System.in);
    }
    /**
     * Runs the employee data management system.
     * Displays a menu with available commands and executes the selected command.
     */
    public void run() {
        boolean isRunning = true;
        EmployeeService es = new EmployeeServiceImpl();
        while (isRunning) {
            showMenu();
            int choice = Integer.parseInt(sc.nextLine());
            Command cmd;
            switch (choice) {
                case 1:
                    cmd = new AddEmployeeCommand(es);
                    cmd.execute();
                    break;
                case 2:
                    cmd = new EditEmployeeCommand(es);
                    cmd.execute();
                    break;
                case 3:
                    cmd = new FireEmployeeCommand(es);
                    cmd.execute();
                    break;
                case 4:
                    cmd = new ListEmployeesCommand(es);
                    cmd.execute();
                    break;
                case 5:
                    cmd=new SearchEmployeesByDepartmentCommand(es);
                    cmd.execute();
                    break;
                case 6:
                    cmd=new SearchEmployeeByIdCommand(es);
                    cmd.execute();
                    break;
                case 7:
                    cmd=new SearchEmployeesByFirstNameCommand(es);
                    cmd.execute();
                    break;
                case 8:
                    cmd = new ExitCommand(es);
                    cmd.execute();
                    isRunning = false;
                    break;
                default:
                    System.out.println(INVALID_INPUT);
            }
        }
    }

    private void showMenu() {
        System.out.println("Choose command: " +
                "\n1.Add Employee" +
                "\n2.Edit Employee" +
                "\n3.Fire Employee" +
                "\n4.List all employees" +
                "\n5.Search by department" +
                "\n6.Search by id" +
                "\n7.Search by First name" +
                "\n8.Save & Exit");
    }

}
