package entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class UserTest {
    @Test
    void given123Password_whenPasswordIsNotValid_thenIsFalse() {
        User user = new User("Kushagra", "abcd");

        assertFalse(user.passwordIsValid());
    }
}
