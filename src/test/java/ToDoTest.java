import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDoTest {
    @Test
    public void toStringTest() {
        ToDo T = new ToDo("Read a Book.");
        assertEquals("[T][\u2718] Read a Book.", T.toString());
        T.markAsDone();
        assertEquals("[T][\u2713s] Read a Book.", T.toString());
    }
}