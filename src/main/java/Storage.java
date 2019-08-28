import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

class Storage {
    private File file;

    public Storage(String filePath) {
        this.file = new File(filePath);
    }

    public ArrayList<Task> load() throws DukeException {
        ArrayList<Task> taskList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String inputString = scanner.nextLine();
                String[] splitString = inputString.split(" / ", 4);
                String taskType = splitString[0];
                boolean isDone = splitString[1].equals("done") ? true : false;
                String description = splitString[2];
                switch (taskType) {
                    case "todo":
                    case "Todo":
                        ToDos T = new ToDos(description);
                        T.setDone(isDone);
                        taskList.add(T);
                        break;
                    case "deadline":
                    case "Deadline":
                        String by = splitString[3];
                        Deadlines D = new Deadlines(description, by);
                        D.setDone(isDone);
                        taskList.add(D);
                        break;
                    case "event":
                    case "Event":
                        String at = splitString[3];
                        Events E = new Events(description, at);
                        E.setDone(isDone);
                        taskList.add(E);
                        break;
                }
            }
            scanner.close();
            return taskList;
        } catch (FileNotFoundException e) {
            try {
                file.createNewFile();
                return taskList;
            } catch (IOException f) {
                throw new DukeException("File not found and unable to create one.");
            }
        }
    }

    public void writeToFile(TaskList taskList) throws IOException {
        ArrayList<Task> tempTaskList = taskList.getTaskList();
        FileWriter fileWriter = new FileWriter(file);
        for (Task task : tempTaskList) {
            if (task instanceof ToDos) {
                fileWriter.write("todo / ");
                if (task.isDone()) {
                    fileWriter.write("done / ");
                } else {
                    fileWriter.write("notdone / ");
                }
                fileWriter.write(task.getDescription() + "\n");
            } else if (task instanceof Deadlines) {
                Deadlines D = (Deadlines) task;
                fileWriter.write("deadline / ");
                if (task.isDone()) {
                    fileWriter.write("done / ");
                } else {
                    fileWriter.write("notdone / ");
                }
                fileWriter.write(D.getDescription() + " / ");
                fileWriter.write(D.getBy() + "\n");
            } else {
                Events E = (Events) task;
                fileWriter.write("event / ");
                if (task.isDone()) {
                    fileWriter.write("done / ");
                } else {
                    fileWriter.write("notdone / ");
                }
                fileWriter.write(E.getDescription() + " / ");
                fileWriter.write(E.getAt() + "\n");
            }
        }
        fileWriter.close();
    }

    public void deleteFile() {
        file.delete();
    }
}