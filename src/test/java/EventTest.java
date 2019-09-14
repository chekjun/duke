import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    @Test
    public void toStringTest() {
        Event E = new Event("Read a Book.", "1/1/1 0000");
        assertEquals("[E][\u2718] Read a Book. (at: 1st January 1, 12:00AM)", E.toString());
        E.markAsDone();
        assertEquals("[E][\u2713s] Read a Book.", E.toString());
    }
}
