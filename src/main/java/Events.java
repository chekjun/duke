class Events extends Task {
    private String at;
    private String parsedAt;

    public Events(String description, String at) {
        super(description);
        this.at = at;
        this.parsedAt = at;
    }

    public String getAt() {
        return at;
    }

    /**
     * @return the parsedAt
     */
    public String getParsedAt() {
        return parsedAt;
    }

    /**
     * @param parsedAt the parsedAt to set
     */
    public void setParsedAt(String parsedAt) {
        this.parsedAt = parsedAt;
    }

    @Override
    public String toString() {
        return " [E]" + super.toString() + " (at: " + parsedAt + ")";
    }
}