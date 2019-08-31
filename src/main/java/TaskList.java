import java.util.ArrayList;

public class TaskList {
    private ArrayList<Task> taskList;

    public TaskList() {
        this.taskList = new ArrayList<Task>();
    }

    public TaskList(ArrayList<Task> taskList) {
        this.taskList = taskList;
    }

    public int countTasks() {
        int numTasks = 0;
        for (Task t : taskList) {
            if (!t.isDone()) {
                ++numTasks;
            }
        }
        return numTasks;
    }

    public void addTask(Task t) {
        taskList.add(t);
    }

    public void doneTask(int i) {
        Task t = taskList.get(i);
        t.markAsDone();
    }

    public void deleteTask(int i) {
        taskList.remove(i);
    }

    public void searchTask(Ui ui, String str) {
        for (int i = 0; i < taskList.size(); ++i) {
            if (taskList.get(i).getDescription().contains(str)) {
                ui.printTask(i + 1, taskList.get(i));
            }
        }
    }

    public void listTask(Ui ui) {
        for (int i = 0; i < taskList.size(); ++i) {
            ui.printTask(i + 1, taskList.get(i));
        }
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }
}