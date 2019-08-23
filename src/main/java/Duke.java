import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean shutdown = false;
        String inputString;
        
        Response.printWelcome();

        while (!shutdown) {
            inputString = scanner.nextLine();
            if (inputString.equals("bye")) {
                shutdown = true;
                Response.printGoodbye();
            } else if (inputString.equals("list")) {
                taskManager.listTasks();
            } else if (inputString.length() > 5 && inputString.substring(0, 4).equals("done")) {
                taskManager.doneTask(Integer.parseInt(inputString.substring(5)));
            } else {
                Task t = new Task(inputString);
                taskManager.addTask(t);
                /*
                if (inputString.length() > 5 && inputString.substring(0, 4).equals("todo")) {
                    
                } else if (inputString.length() > 9 && inputString.substring(0, 8).equals("deadline")) {
                    
                } else if (inputString.length() > 6 && inputString.substring(0, 5).equals("event")) {
                    
                } else {

                }
                */
            }
        }
    }
}