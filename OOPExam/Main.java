package sms;

import sms.manager.Engine;
import sms.service.EmployeeService;
import sms.service.impl.EmployeeServiceImpl;
/**
 * Main class serves as the entry point for the employee data management system.
 * It initializes the necessary services and starts the system by running the Engine
 */
public class Main {
    public static void main(String[] args) {
        EmployeeService es=new EmployeeServiceImpl();
        Engine engine=new Engine();
        engine.run();
    }
}
