import java.io.IOException;

public class ExitCommand implements Command {
    public ExitCommand() {}

    public void execute(TaskList tasks, Ui ui, Storage storage) {
        try {
            storage.writeToFile(tasks);
        } catch (IOException e) {
            System.out.println("Failed writing to file.");
        }
        ui.showExit();
    }

    public boolean isExit() {
        return true;
    }
}