package entities;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MessageTest {

    @Test
    public void whenContentIsValid_thenIsTrue() {
        Message message = new Message("Baeldung", "sender", "GroupID");
        assertTrue(message.contentIsValid());

    }

    @Test
    public void whenContentIsNotValid_thenIsFalse() {
        Message message = new Message("", "sender", "GroupID");
        assertFalse(message.contentIsValid());
    }


}