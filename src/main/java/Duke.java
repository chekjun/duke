import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        String logo =
                  " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        Scanner scanner = new Scanner(System.in);

        System.out.println("✓");

        String inputString;
        ArrayList<Task> taskList = new ArrayList<Task>();
        boolean shutdown = false;
        while (!shutdown) {
            inputString = scanner.nextLine();
            if (inputString.equals("bye")) {
                System.out.println("Bye. Hope to see you again soon!");
                shutdown = true;
            } else if (inputString.equals("list")) {
                System.out.println("Here are the tasks in your list:");
                for (int i = 1; i <= taskList.size(); ++i) {
                    System.out.println(i + ". ["
                        + taskList.get(i - 1).getStatusIcon()
                        + "] "
                        + taskList.get(i - 1).description);
                }
            } else if (inputString.length() > 4 && inputString.substring(0, 4).equals("done")) {
                System.out.println("Nice! I've marked this task as done:");
                int doneNum = Integer.parseInt(inputString.substring(5));
                Task t = taskList.get(doneNum - 1);
                t.isDone = true;
                System.out.println("[\u2713] " + t.description);
            } else {
                Task t = new Task(inputString);
                taskList.add(t);
                System.out.println("added: " + inputString);
            }
        }
    }
}