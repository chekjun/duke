public class FindCommand implements Command {
    private String commandDetail;

    public FindCommand(String commandDetail) {
        this.commandDetail = commandDetail;
    }

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