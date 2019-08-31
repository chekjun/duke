public class ListCommand implements Command {
    public ListCommand() {}
    
    public void execute(TaskList tasks, Ui ui, Storage storage) {
        ui.showListTask();
        tasks.listTask(ui);
        ui.showNumTask(tasks);
    }

    public boolean isExit() {
        return false;
    }
}