package sms.command;

import java.util.HashMap;
import java.util.Map;
/**
 * The RemoteControll class represents a remote control for executing commands.
 * It associates command numbers with corresponding command objects.
 */
public class RemoteControll {
    private final Map<Integer,Command>commands=new HashMap<>();
    /**
     * Sets a command for a specific command number.
     * @param cmdNum  The command number.
     * @param command The command object to associate with the number.
     */
    public void setCommand(int cmdNum,Command command){
        commands.put(cmdNum,command);
    }
    /**
     * Executes the command associated with the given command number.
     * @param num The command number to execute.
     */
    public void choosedNum(int num){
        if (commands.containsKey(num)){
            commands.get(num).execute();
        }else{
            System.out.println("Invalid input");
        }
    }
}
