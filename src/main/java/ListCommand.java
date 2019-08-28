class ListCommand implements Command {
    public ListCommand() {}
    
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        ui.showListTask();
        taskList.listTask(ui);
        ui.showNumTask(taskList);
    }

    public boolean isExit() {
        return false;
    }
}