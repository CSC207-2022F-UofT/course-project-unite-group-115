package entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void whenContentIsValid_thenIsTrue() {
        Message message = new Message("Baeldung", "sender", "GroupID");
        assertTrue(message.contentIsValid());

    }

    @Test
    void whenContentIsNotValid_thenIsFalse() {
        Message message = new Message("", "sender", "GroupID");
        assertFalse(message.contentIsValid());
    }


}