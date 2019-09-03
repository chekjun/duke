public class Deadline extends Task {
    protected String by;
    protected String parsedBy;

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public String getParsedBy() {
        return parsedBy;
    }

    public void setParsedBy(String parsedBy) {
        this.parsedBy = parsedBy;
    }

    public Deadline(String description, String by) {
        super(description);
        this.by = by;
    }

    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + parsedBy + ")";
    }
}