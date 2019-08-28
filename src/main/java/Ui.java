import java.util.Scanner;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

class Ui {
    private Scanner scanner;
    private PrintStream printer;

    public Ui() {
        this.scanner = new Scanner(System.in);
        this.printer =  new PrintStream(System.out, true, StandardCharsets.UTF_8);
    }

    public void showLine() {
        System.out.println("    ____________________________________________________________");
    }

    public void showIndent() {
        System.out.print("     ");
    }
    
    public void showWelcome() {
        String logo =
              "      ____        _        \n"
            + "     |  _ \\ _   _| | _____ \n"
            + "     | | | | | | | |/ / _ \\\n"
            + "     | |_| | |_| |   <  __/\n"
            + "     |____/ \\__,_|_|\\_\\___|\n";
        showLine();
        System.out.println(logo);
        showIndent();
        System.out.println("Hello! I'm Duke.");
        showIndent();
        System.out.println("What can I do for you?");
        showLine();
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showAddTask() {
        showIndent();
        System.out.println("Got it. I've added this task:");
    }

    public void showDoneTask() {
        showIndent();
        System.out.println("Nice! I've marked this task as done:");
    }

    public void showDeleteTask() {
        showIndent();
        System.out.println("Noted. I've removed this task:");
    }

    public void showListTask() {
        showIndent();
        System.out.println("Here are the tasks in your list:");
    }

    public void printTask(Task task) {
        showIndent();
        printer.println(task.toString());
    }

    public void printTask(int idx, Task task) {
        showIndent();
        printer.println(idx + "." + task.toString());
    }

    public void showNumTask(TaskList taskList) {
        showIndent();
        System.out.println("Now you have " + taskList.countTasks() + " tasks in the list.");
    }

    public void showError(String errorMessage) {
        showIndent();
        System.out.print(errorMessage);
    }

    public void showLoadingSuccess() {
        showIndent();
        System.out.println("Save file found, loading data into Duke.");
    }

    public void showLoadingError() {
        showIndent();
        System.out.println("Save file not found, creating a new save file.");
    }

    public void showWritingError() {
        showIndent();
        System.out.println("Problem writing to file, deleting current one.");
    }

    public void showGoodbye() {
        showIndent();
        System.out.println("Bye. Hope to see you again soon!");
    }
}