public class AddCommand implements Command {
    private CommandType commandType;
    private String commandDetail;

    public AddCommand(CommandType commandType, String commandDetail){
        this.commandType = commandType;
        this.commandDetail = commandDetail;
    }

    /**
     * Executes Add Command which is specifically to add tasks to taskList.
     *
     * @param taskList Contains an ArrayList to store all tasks.
     * @param ui Class which contains response messages for user.
     * @param storage Class which handles read, write from text file.
     * @throws DukeException Used for errors that have been handled.
     */
    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        switch (commandType) {
            case TODO:
                ToDo T = validateToDo(commandDetail);
                taskList.addTask(T);
                ui.showAddTask();
                ui.printTask(T);
                break;
            case DEADLINE:
                Deadline D = validateDeadline(commandDetail);
                taskList.addTask(D);
                ui.showAddTask();
                ui.printTask(D);
                break;
            case EVENT:
                Event E = validateEvent(commandDetail);
                taskList.addTask(E);
                ui.showAddTask();
                ui.printTask(E);
                break;
            default:
                throw new DukeException("Something went wrong executing AddCommand!\n");
        }
        ui.showNumTask(taskList);
    }

    public ToDo validateToDo(String str) throws DukeException {
        if (str.isBlank())
            throw new DukeException("Todo cannot be empty!\n");
        else
            return new ToDo(str);
    }
    
    public Deadline validateDeadline(String str) throws DukeException {
        String[] splitString = str.split(" /by ", 2);
        if (splitString[0].isBlank()) {
            throw new DukeException("Deadline cannot be empty.\n");
        }
        if (splitString.length == 1) {
            throw new DukeException("The format of deadline should be DESCRIPTION /by dd/MM/yyyy\n");
        }
        Deadline D = new Deadline(splitString[0], splitString[1]);
        D.setParsedBy(Parser.parseDateTime(splitString[1]));
        return D;
    }

    public Event validateEvent(String str) throws DukeException {
        String[] splitString = str.split(" /at ", 2);
        if (splitString[0].isBlank()) {
            throw new DukeException("Event cannot be empty.\n");
        }
        if (splitString.length == 1) {
            throw new DukeException("The format of event should be DESCRIPTION /by dd/MM/yyyy\n");
        }
        Event E = new Event(splitString[0], splitString[1]);
        E.setParsedAt(Parser.parseDateTime(splitString[1]));
        return E;
    }

    public boolean isExit() {
        return false;
    }
} 