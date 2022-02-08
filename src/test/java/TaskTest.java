import org.junit.jupiter.api.Test;
import scheduler.Task;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    private final Task task = new Task();
    @Test
    public void test_fact() {
        assertEquals("24", task.compute(4));
        assertEquals("120", task.compute(30000));
    }
}