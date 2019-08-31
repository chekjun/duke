public class Event extends Task {
    protected String at;
    protected String parsedAt;

    public String getAt() {
        return at;
    }

    public void setAt(String at) {
        this.at = at;
    }

    public Event(String description, String at) {
        super(description);
        this.at = at;
    }

    public String getParsedAt() {
        return parsedAt;
    }

    public void setParsedAt(String parsedAt) {
        this.parsedAt = parsedAt;
    }
    
    @Override
    public String toString() {
        return " [E] " + super.toString() + " (at: " + parsedAt + ")";
    }
}