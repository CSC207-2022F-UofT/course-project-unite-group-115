package entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertFalse;
public class UserTest {
    @Test
    void givenAbcdPassword_whenPasswordIsNotValid_thenIsFalse() {
        User user = new User("Kushagra", "Abcd");

        assertFalse(user.passwordIsValid());
    }
}
