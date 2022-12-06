package user_register.interface_adapters;

public class UserCreationFailed extends RuntimeException {
    /**
     * Creates an error with the message <error>. Should be used when a user has failed to be created.
     * @param error a String describing the error that occurred
     */
    public UserCreationFailed(String error) {
        super(error);
    }
}
