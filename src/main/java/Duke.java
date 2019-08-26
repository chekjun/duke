import java.util.Scanner;

public class Duke {
    private static boolean running = true;
    private static String inputString;
    private static TaskManager taskManager = new TaskManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
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
                }
            } catch (DukeException dException) {
                System.out.println(Format.divider
                    + Format.indent + dException
                    + Format.divider);
                continue;
            }
        }
    }

    static int validateDoneInput() throws DukeException {
        if (inputString.length() == 4) {
            throw new DukeException("Please specify a task.\n");
        } else if (inputString.length() == 5) {
            if (inputString.charAt(4) == ' ') {
                throw new DukeException("Please specify a task.\n");
            } else {
                throw new DukeException("Invalid input given.\n");
            }
        } else {
            int doneNum = Integer.parseInt(inputString.substring(5));
            if (doneNum < 1 || doneNum > taskManager.getTaskList().size()) {
                throw new DukeException("Task does not exist.\n");
            } else {
                return doneNum;
            }
        }
    }

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
            } else {
                throw new DukeException("Invalid input given.\n");
            }
        } else {
            ToDos T = new ToDos(inputString.substring(5));
            return T;
        }
    }

    static Deadlines validateDeadlines() throws DukeException {
        if (inputString.length() == 8) {
            throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.\n");
        } else if (inputString.length() == 9) {
            if (inputString.charAt(8) == ' ') {
                throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.\n");
            } else {
                throw new DukeException("Invalid input given.\n");
            }
        } else {
            int descriptionEndIndex = inputString.indexOf("/");
            if (descriptionEndIndex == -1 || descriptionEndIndex <= 9 || inputString.length() < descriptionEndIndex + 5) {
                throw new DukeException("Invalid input given.\n");
            }
            String description = inputString.substring(9, descriptionEndIndex - 1);
            String by = inputString.substring(descriptionEndIndex + 4);
            Deadlines D = new Deadlines(description, by);
            return D;
        }
    }

    static Events validateEvents() throws DukeException {
        if (inputString.length() == 5) {
            throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.\n");
        } else if (inputString.length() == 6) {
            if (inputString.charAt(7) == ' ') {
                throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.\n");
            }  else {
                throw new DukeException("Invalid input given.\n");
            }
        } else {
            int descriptionEndIndex = inputString.indexOf("/");
            if (descriptionEndIndex == -1 || descriptionEndIndex <= 6 || inputString.length() < descriptionEndIndex + 5) {
                throw new DukeException("Invalid input given.\n");
            }
            String description = inputString.substring(6, descriptionEndIndex - 1);
            String at = inputString.substring(descriptionEndIndex + 4);
            Events E = new Events(description, at);
            return E;
        }
    }

}