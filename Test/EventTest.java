import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventTest {

    @Test
    void isStarve() {
        Event event = new Event();
        assertEquals(false,event.isStarved());
    }
}
