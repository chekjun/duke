public class Deadlines extends Task {
    private String by; // complete deadline by this time

    public Deadlines(String description, String by) {
        super(description);
        this.by = by;
    }

    public String getBy() {
        return by;
    }

    @Override
    public String toString() {
        return " [D]" + super.toString() + " (by: " + by + ")";
    }
}