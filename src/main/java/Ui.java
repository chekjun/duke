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
        System.out.println("____________________________________________________________");
    }
    
    public void showWelcome() {
        String logo =
              " ____        _        \n"
            + "|  _ \\ _   _| | _____ \n"
            + "| | | | | | | |/ / _ \\\n"
            + "| |_| | |_| |   <  __/\n"
            + "|____/ \\__,_|_|\\_\\___|\n";
        showLine();
        System.out.println(logo);
        System.out.println("Hello! I'm Duke.");
        System.out.println("What can I do for you?");
        showLine();
    }

    public String readCommand() {
        return scanner.nextLine();
    }

    public void showAddTask() {
        System.out.println("Got it. I've added this task:");
    }

    public void showDoneTask() {
        System.out.println("Nice! I've marked this task as done:");
    }

    public void showDeleteTask() {
        System.out.println("Noted. I've removed this task:");
    }

    public void showListTask() {
        System.out.println("Here are the tasks in your list:");
    }

    public void showFindTask() {
        System.out.println("Here are the matching tasks in your list:");
    }

    public void printTask(Task task) {
        printer.println(task.toString());
    }

    public void printTask(int idx, Task task) {
        printer.println(idx + ". " + task.toString());
    }

    public void showExit() {
        System.out.println("Bye. Hope to see you again soon!");
    }

    public void showNumTask(TaskList taskList) {
        System.out.println("Now you have " + taskList.countTasks() + " tasks in the list.");
    }

    public void showError(String errorMessage) {
        System.out.print(errorMessage);
    }

    public void showLoadingSuccess() {
        System.out.println("Save file found, loading data into Duke.");
    }

    public void showLoadingError() {
        System.out.println("Save file not found, creating a new save file.");
    }

    public void showWritingError() {
        System.out.println("Problem writing to file, deleting current one.");
    }

    public void showCreateFile() {
        System.out.println("Save file not found, new save file created successfully.");
    }


}