import java.util.Scanner;

public class Duke {
    private static TaskManager taskManager = new TaskManager();
    private static Scanner scanner = new Scanner(System.in);
    private static boolean running;
    private static String userInput;
    private static String splitString[];

    public static void main(String[] args) {
<<<<<<< HEAD
        Response.printWelcome();        
        running = true;
        do {
            userInput = scanner.nextLine();
            if (!userInput.isEmpty()) {
                executeCommand();
            }
        } while (running);
        scanner.close();
        Response.printGoodbye();
    }

    enum Command {
        DONE,
        DELETE,
        TODO,
        DEADLINE,
        EVENT
    }

    private static void executeCommand() {
        splitString = userInput.split(" ", 2);
        Command command;
        if (splitString.length == 1) {
            if (userInput.equals("bye")) {
                running = false;
            } else if (userInput.equals("list")) {
                taskManager.listTasks();
            } else if (userInput.equals("done")) {
                System.out.println(Format.divider
                    + Format.indent + " Please specify a task to do\n"
                    + Format.divider);
            } else if (userInput.equals("delete")) {
                System.out.println(Format.divider
                    + Format.indent + " Please specify a task to delete\n"
                    + Format.divider);
            } else if (userInput.equals("todo")) {
                System.out.println(Format.divider
                    + Format.indent + " ☹ OOPS!!! The description of a todo cannot be empty.\n"
                    + Format.divider);
            } else if (userInput.equals("deadline")) {
                System.out.println(Format.divider
                    + Format.indent + " ☹ OOPS!!! The description of a deadline cannot be empty.\n"
                    + Format.divider);
            } else if (userInput.equals("event")) {
                System.out.println(Format.divider
                    + Format.indent + " ☹ OOPS!!! The description of an event cannot be empty.\n"
                    + Format.divider);
            } else {
                System.out.println(Format.divider
                    + Format.indent + " ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n"
                    + Format.divider);
                return;
            }
        } else {
            if (splitString[0].equals("done")) {
                command = Command.DONE;
            } else if (splitString[0].equals("delete")) {
                command = Command.DELETE;
            } else if (splitString[0].equals("todo")) {
                command = Command.TODO;
            } else if (splitString[0].equals("deadline")) {
                command = Command.DEADLINE;
            } else if (splitString[0].equals("event")) {
                command = Command.EVENT;
            } else {
                System.out.println(Format.divider
                    + Format.indent + " ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n"
                    + Format.divider);
                return;
            }
            try {
                switch(command) {
                    case DONE:
                        markDone();
                        break;
                    case DELETE:
                        deleteTask();
                        break;
                    case TODO:
                        addToDo();
                        break;
                    case DEADLINE:
                        addDeadline();
                        break;
                    case EVENT:
                        addEvent();
                        break;
=======
        Response.printWelcome();
        while (running) {
            inputString = scanner.nextLine();
            try {
                if (inputString.equals("bye")) {
                    running = false;
                    scanner.close();
                    Response.printGoodbye();
                } else if (inputString.equals("list")) {
                    taskManager.listTasks();
                } else if (inputString.length() > 3 && inputString.substring(0, 4).equals("done")) {
                    int doneNum = validateDoneInput();
                    taskManager.doneTask(doneNum);
                }  else if (inputString.length() > 5 && inputString.substring(0, 6).equals("delete")) {
                    int deleteNum = validateDeleteInput();
                    taskManager.deleteTask(deleteNum);
                } else {
                    if (inputString.length() > 3 && inputString.substring(0, 4).equals("todo")) {
                        ToDos T = validateToDo();
                        taskManager.addTask(T);
                    } else if (inputString.length() > 7 && inputString.substring(0, 8).equals("deadline")) {
                        Deadlines D = validateDeadlines();
                        taskManager.addTask(D);
                    } else if (inputString.length() > 4 && inputString.substring(0, 5).equals("event")) {
                        Events E = validateEvents();
                        taskManager.addTask(E);
                    } else {
                        System.out.println(Format.divider
                            + Format.indent + " ☹ OOPS!!! I'm sorry, but I don't know what that means :-(\n"
                            + Format.divider);
                    }
>>>>>>> bd2183692cbaaa5f9b46b7faf17e284781d2b56f
                }
            } catch(DukeException dukeException) {
                System.out.println(Format.divider
                    + Format.indent + dukeException
                    + Format.divider);
                return;
            }
        }
    }

    public static boolean isInteger(String string, int radix) {
        if (string.isEmpty()) {
            return false;
        }
        for (int i = 0; i < string.length(); i++) {
            if (i == 0 && string.charAt(i) == '-') {
                if (string.length() == 1) {
                    return false;
                } else {
                    continue;
                }
            }
            if (Character.digit(string.charAt(i),radix) < 0) {
                return false;
            }
        }
        return true;
    }

<<<<<<< HEAD
    private static void markDone() throws DukeException {
        if (isInteger(splitString[1], 10)) {
            int doneNum = Integer.parseInt(splitString[1]);
            if (doneNum >= 1 && doneNum <= taskManager.getTaskList().size()) {
                taskManager.doneTask(doneNum);
=======
    static int validateDeleteInput() throws DukeException {
        if (inputString.length() == 6) {
            throw new DukeException("Please specify a task.\n");
        } else if (inputString.length() == 7) {
            if (inputString.charAt(4) == ' ') {
                throw new DukeException("Please specify a task.\n");
            } else {
                throw new DukeException("Invalid input given.\n");
            }
        } else {
            int deleteNum = Integer.parseInt(inputString.substring(7));
            if (deleteNum < 1 || deleteNum > taskManager.getTaskList().size()) {
                throw new DukeException("Task does not exist.\n");
            } else {
                return deleteNum;
            }
        }
    }

    static ToDos validateToDo() throws DukeException {
        if (inputString.length() == 4) {
            throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.\n");
        } else if (inputString.length() == 5) {
            if (inputString.charAt(4) == ' ') {
                throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.\n");
>>>>>>> bd2183692cbaaa5f9b46b7faf17e284781d2b56f
            } else {
                throw new DukeException("Task does not exist.\n");
            }
        } else {
            throw new DukeException("Invalid input.\n");
        }
    }

    private static void deleteTask() throws DukeException {
        if (isInteger(splitString[1], 10)) {
            int doneNum = Integer.parseInt(splitString[1]);
            if (doneNum >= 1 && doneNum <= taskManager.getTaskList().size()) {
                taskManager.deleteTask(doneNum);
            } else {
                throw new DukeException("Task does not exist.\n");
            }
        } else {
            throw new DukeException("Invalid input.\n");
        }
    }

    private static void addToDo() {
        taskManager.addTask(new ToDos(splitString[1]));
    }

    private static void addDeadline() throws DukeException {
        if (splitString[1].contains(" /by ")) {
            splitString = splitString[1].split(" /by ", 2);
            int slashIndex = splitString[1].indexOf("/");
            if (splitString.length == 1) {
                throw new DukeException(" ☹ OOPS!!! The description of a deadline cannot be empty.\n");
            } else if (splitString.length == 2) {
                String description = splitString[0];
                String by = splitString[1];
                taskManager.addTask(new Deadlines(description, by));
            } else {
                throw new DukeException("Invalid input given.\n");
            }
        } else {
            throw new DukeException("Invalid input given.\n");
        }
    }

    private static void addEvent() throws DukeException {
        if (splitString[1].contains(" /by ")) {
            splitString = splitString[1].split(" /by ", 2);
            if (splitString.length == 1) {
                throw new DukeException(" ☹ OOPS!!! The description of an event cannot be empty.\n");
            } else if (splitString.length == 2) {
                String description = splitString[0];
                String at = splitString[1];
                taskManager.addTask(new Events(description, at));
            } else {
                throw new DukeException("Invalid input given.\n");
            }
        } else {
            throw new DukeException("Invalid input given.\n");
        }
    }
}