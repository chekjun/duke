import java.io.IOException;

public class Duke {
    /*
    * Ui: deals with interactions with the user
    * Storage: deals with loading tasks from the file and saving tasks in the file
    * Parser: deals with making sense of the user command
    * TaskList: contains the task list e.g., it has operations to add/delete tasks in the list
    */
    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        storage = new Storage(filePath);
        try {
            tasks = new TaskList(storage.load());
        } catch (DukeException e) {
            ui.showLoadingError();
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            try {
                String fullCommand = ui.readCommand();
                ui.showLine();
                Command c = Parser.parse(fullCommand);
                c.execute(tasks, ui, storage);
                isExit = c.isExit();
                try {
                    storage.writeToFile(tasks);
                } catch (IOException e) {
                    System.out.println("Failed writing to file.");
                }
            } catch (DukeException e) {
                ui.showError(e.getMessage());
            } finally {
                ui.showLine();
            }
        }
    }

    public static void main(String[] args) {
        // Duke("C:/Users/Chek Jun/Google Drive/1920S1/CS2113T/duke/src/main/java/data.txt").run(); // desktop path
        new Duke("C:/Users/Lim Chek Jun/Google Drive/1920S1/CS2113T/duke/text-ui-test/data.txt").run(); // laptop path
    }
}