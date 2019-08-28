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
        Task t = taskList.get(i - 1);
        if (!t.isDone()) {
            t.setDone(true);
        }
    }

    public void deleteTask(int i) {
        taskList.remove(i - 1);
    }

    public void listTask(Ui ui) {
        for (int i = 1; i <= taskList.size(); ++i) {
            ui.printTask(i, taskList.get(i - 1));
        }
    }

    public ArrayList<Task> getTaskList() {
        return taskList;
    }
}