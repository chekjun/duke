class AddCommand implements Command {
    private CommandType commandType;
    private String commandDetail;

    public AddCommand(CommandType commandType, String commandDetail){
        this.commandType = commandType;
        this.commandDetail = commandDetail;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        switch(commandType) {
            case TODO:
                if (commandDetail.isBlank()) {
                    throw new DukeException("☹ OOPS!!! The description of a todo cannot be empty.\n");
                } else {
                    ToDos T = new ToDos(commandDetail);
                    taskList.addTask(T);
                    ui.showAddTask();
                    ui.printTask(T);
                    ui.showNumTask(taskList);
                }
                break;
            case DEADLINE:
                if (commandDetail.isBlank()) {
                    throw new DukeException("☹ OOPS!!! The description of a deadline cannot be empty.\n");
                } else {
                    Deadlines D = validateDeadline(commandDetail);
                    taskList.addTask(D);
                    ui.showAddTask();
                    ui.printTask(D);
                    ui.showNumTask(taskList);
                }
                break;
            case EVENT:
                if (commandDetail.isBlank()) {
                    throw new DukeException("☹ OOPS!!! The description of an event cannot be empty.\n");
                } else {
                    Events E = validateEvent(commandDetail);
                    taskList.addTask(E);
                    ui.showAddTask();
                    ui.printTask(E);
                    ui.showNumTask(taskList);
                }
                break;
            default:
                throw new DukeException("Something went wrong executing AddCommand!");
        }
    }

    public Deadlines validateDeadline(String str) throws DukeException {
        String[] splitString = str.split(" /by ", 2);
        if (splitString.length == 1) {
            throw new DukeException("The format of deadline should be DESCRIPTION /by D/M/Y\n");
        } else {
            return new Deadlines(splitString[0], splitString[1]);
        }
    }

    public Events validateEvent(String str) throws DukeException {
        String[] splitString = str.split(" /at ", 2);
        if (splitString.length == 1) {
            throw new DukeException("The format of event should be DESCRIPTION /by D/M/Y\n");
        } else {
            return new Events(splitString[0], splitString[1]);
        }
    }

    public boolean isExit() {
        return false;
    }
}