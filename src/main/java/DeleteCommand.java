public class DeleteCommand implements Command {
    private String commandDetail;

    public DeleteCommand(String commandDetail) {
        this.commandDetail = commandDetail;
    }

    /**
     * Executes Delete Command which is specifically to add delete tasks from taskList.
     *
     * @param taskList Contains an ArrayList to store all tasks.
     * @param ui Class which contains response messages for user.
     * @param storage Class which handles read, write from text file.
     * @throws DukeException Used for errors that have been handled.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (commandDetail.isBlank()) {
            throw new DukeException("Please specify a task.\n");
        } else if (Parser.isInteger(commandDetail, 10)) {
            int doneNum = Integer.parseInt(commandDetail);
            if (doneNum > 0 && doneNum <= tasks.getTaskList().size()) {
                Task task = tasks.getTaskList().get(doneNum - 1);
                ui.showDeleteTask();
                ui.printTask(task);
                tasks.deleteTask(doneNum - 1);
                ui.showNumTask(tasks);
            } else {
                throw new DukeException("Task does not exist.\n");
            }
        } else {
            throw new DukeException("Index of task must be numerical value!\n");
        }
    }

    public boolean isExit() {
        return false;
    }
}