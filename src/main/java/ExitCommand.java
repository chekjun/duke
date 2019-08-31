public class ExitCommand implements Command {
    public ExitCommand() {}

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showExit();
    }

    public boolean isExit() {
        return true;
    }
}