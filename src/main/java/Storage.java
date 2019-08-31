import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Storage {
    private File file;

    public Storage(String filePath) {
        this.file = new File(filePath);
    }

    public ArrayList<Task> load() throws DukeException {
        ArrayList<Task> tasks = new ArrayList<Task>();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String inputString = scanner.nextLine();
                String[] splitString = inputString.split(" : : ", 4);
                String taskType = splitString[0];
                String isDone = splitString[1];
                String description = splitString[2];
                switch (taskType) {
                    case "T":
                        ToDo T = new ToDo(description);
                        if (isDone == "1") {
                            T.markAsDone();
                        }
                        tasks.add(T);
                        break;
                    case "D":
                        String by = splitString[3];
                        Deadline D = new Deadline(description, by);
                        if (isDone == "1") {
                            D.markAsDone();
                        }
                        D.setParsedBy(Parser.parseDateTime(by));
                        tasks.add(D);
                        break;
                    case "E":
                        String at = splitString[3];
                        Event E = new Event(description, at);
                        if (isDone == "1") {
                            E.markAsDone();
                        }
                        E.setParsedAt(Parser.parseDateTime(at));
                        tasks.add(E);
                        break;
                }
            }
            scanner.close();
            return tasks;
        } catch (FileNotFoundException e) {
            try {
                createNewFile();
                return tasks;
            } catch (IOException e2) {
                throw new DukeException("File not found and unable to create one.");
            }
        } catch (ArrayIndexOutOfBoundsException e1) {
            try {
                deleteFile();
                createNewFile();
                return tasks;
            } catch (IOException e2) {
                throw new DukeException("File corrupted and unable to create one.");
            }
        }
    }

    public void createNewFile() throws IOException {
        file.createNewFile();
    }

    public void deleteFile() {
        file.delete();
    }

    public void writeToFile(TaskList tasks) throws IOException {
        ArrayList<Task> taskList = tasks.getTaskList();
        FileWriter fileWriter = new FileWriter(file);
        for (Task task : taskList) {
            if (task instanceof ToDo) {
                fileWriter.write("T : : ");
                if (task.isDone()) {
                    fileWriter.write("1 : : ");
                } else {
                    fileWriter.write("0 : : ");
                }
                fileWriter.write(task.description + "\n");
            } else if (task instanceof Deadline) {
                fileWriter.write("D : : ");
                Deadline D = (Deadline) task;
                if (task.isDone()) {
                    fileWriter.write("1 : : ");
                } else {
                    fileWriter.write("0 : : ");
                }
                fileWriter.write(D.getDescription() + " : : " + D.getBy() + "\n");
            } else {
                fileWriter.write("E : : ");
                Event E = (Event) task;
                if (task.isDone()) {
                    fileWriter.write("1 : : ");
                } else {
                    fileWriter.write("0 : : ");
                }
                fileWriter.write(E.getDescription() + " : : " + E.getAt() + "\n");
            }
        }
        fileWriter.close();
    }
}