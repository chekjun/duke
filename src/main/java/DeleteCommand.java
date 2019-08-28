class DeleteCommand implements Command {
    private String commandDetail;

    public DeleteCommand(String commandDetail) {
        this.commandDetail = commandDetail;
    }

    public void execute(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        if (commandDetail.isBlank()) {
            throw new DukeException("Please specify a task.\n");
        } else {
            if (isInteger(commandDetail, 10)) {
                int doneNum = Integer.parseInt(commandDetail);
                if (doneNum >= 1 && doneNum <= taskList.getTaskList().size()) {
                    ui.showDeleteTask();
                    Task task = taskList.getTaskList().get(doneNum - 1);
                    ui.printTask(task);
                    taskList.deleteTask(doneNum);
                    ui.showNumTask(taskList);
                } else {
                    throw new DukeException("Task does not exist.\n");
                }
            } else {
                throw new DukeException("Index of task must be numerical value!\n");
            }
        }
    }

    public boolean isExit() {
        return false;
    }

    public boolean isInteger(String string, int radix) {
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
}