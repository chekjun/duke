import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class TaskManager {
    private PrintStream printer = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    private ArrayList<Task> taskList;

    public TaskManager() {
        this.taskList = new ArrayList<Task>();
    }

    public void listTasks() {
        printer.println(Format.divider
        + Format.indent + " Here are the tasks in your list:");
        for (int i = 1; i <= taskList.size(); ++i) {
            printer.println(Format.indent + " "
                + i + ". [" + taskList.get(i - 1).getStatusIcon() + "] "
                + taskList.get(i - 1).getDescription());
        }
        printer.println(Format.divider + "\n");
    }

    public void doneTask(int i) {
        Task t = taskList.get(i - 1);
        t.setDone(true);
        printer.println(Format.divider
            + Format.indent + " Nice! I've marked this task as done:\n"
            + Format.indent + "   [" + t.getStatusIcon() + "] " + t.getDescription() + "\n"
            + Format.divider);
    }

    public void addTask(Task t) {
        taskList.add(t);
        printer.println(Format.divider
        + Format.indent + " added: " + t.getDescription() + "\n"
        + Format.divider);
    }
}