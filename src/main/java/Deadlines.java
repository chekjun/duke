class Deadlines extends Task {
    private String by;
    private String parsedby;

    public Deadlines(String description, String by) {
        super(description);
        this.by = by;
        this.parsedby = by;
    }

    public String getBy() {
        return by;
    }

    /**
     * @return the parsedby
     */
    public String getParsedby() {
        return parsedby;
    }

    /**
     * @param parsedby the parsedby to set
     */
    public void setParsedby(String parsedby) {
        this.parsedby = parsedby;
    }

    @Override
    public String toString() {
        return " [D]" + super.toString() + " (by: " + parsedby + ")";
    }
}