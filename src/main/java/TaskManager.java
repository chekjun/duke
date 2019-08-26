import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.io.FileWriter;

public class TaskManager {
    private PrintStream printer = new PrintStream(System.out, true, StandardCharsets.UTF_8);
    private int numTasks = 0;
    private ArrayList<Task> taskList;

    public TaskManager() {
        this.taskList = new ArrayList<Task>();
    }

    public void listTasks() {
        printer.println(Format.divider
        + Format.indent + " Here are the tasks in your list:");
        for (int i = 1; i <= taskList.size(); ++i) {
            printer.println(Format.indent + " "
                + i + "." + taskList.get(i - 1).toString());
        }
        printer.println(Format.divider + "\n");
    }

    public void doneTask(int i) {
        Task t = taskList.get(i - 1);
        if (!t.isDone()) {
            t.setDone(true);
            --numTasks;
        }
        printer.println(Format.divider
            + Format.indent + " Nice! I've marked this task as done:\n"
            + Format.indent + t.toString() + "\n"
            + Format.indent + " Now you have " + numTasks + " tasks in the list.\n"
            + Format.divider);
    }
    
    public void deleteTask(int i) {
        Task t = taskList.get(i - 1);
        if (!t.isDone()) {
            --numTasks;
        }
        printer.println(Format.divider
            + Format.indent + " Noted. I've removed this task:\n"
            + Format.indent + t.toString() + "\n"
            + Format.indent + " Now you have " + numTasks + " tasks in the list.\n"
            + Format.divider);
        taskList.remove(i - 1);
    }

    public void addTask(Task t) {
        taskList.add(t);
        ++numTasks;
        printer.println(Format.divider
        + Format.indent + " Got it. I've added this task:\n  "
        + Format.indent + t.toString() + "\n"
        + Format.indent + " Now you have " + numTasks + " tasks in the list.\n"
        + Format.divider);
    }

    /**
     * @return the taskList
     */
    public ArrayList<Task> getTaskList() {
        return taskList;
    }
}