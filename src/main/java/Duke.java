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
                if (inputString.length() > 5 && inputString.substring(0, 4).equals("todo")) {
                    ToDos T = new ToDos(inputString.substring(5));
                    taskManager.addTask(T);
                } else if (inputString.length() > 9 && inputString.substring(0, 8).equals("deadline")) {
                    int descriptionEndIndex = inputString.indexOf("/");
                    String description = inputString.substring(9, descriptionEndIndex - 1);
                    String by = inputString.substring(descriptionEndIndex + 4);
                    Deadlines D = new Deadlines(description, by);
                    taskManager.addTask(D);
                } else if (inputString.length() > 6 && inputString.substring(0, 5).equals("event")) {
                    int descriptionEndIndex = inputString.indexOf("/");
                    String description = inputString.substring(6, descriptionEndIndex - 1);
                    String at = inputString.substring(descriptionEndIndex + 4);
                    Events E = new Events(description, at);
                    taskManager.addTask(E);
                }
            }
        }
    }
}