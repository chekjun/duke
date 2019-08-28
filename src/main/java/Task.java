public class Task {
    private static final String TICK = "[\u2713] ";
    private static final String CROSS = "[\u2718] ";

    private String description;
    private boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean isDone) {
        this.isDone = isDone;
    }

    public String getStatusIcon() {
        return (isDone ? TICK : CROSS);
    }

    public String toString() {
        return getStatusIcon() + description;
    }
}