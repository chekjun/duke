public class FindCommand implements Command {
    private String commandDetail;

    public FindCommand(String commandDetail) {
        this.commandDetail = commandDetail;
    }

    /**
     * Executes Find Command which finds tasks with descriptions containing a specific string.
     *
     * @param taskList Contains an ArrayList to store all tasks.
     * @param ui Class which contains response messages for user.
     * @param storage Class which handles read, write from text file.
     * @throws DukeException Used for errors that have been handled.
     */
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        if (commandDetail.isBlank()) {
            throw new DukeException("Please specify a string to search.\n");
        } else {
            ui.showFindTask();
            tasks.searchTask(ui, commandDetail);
        }
    }

    public boolean isExit() {
        return false;
    }
}