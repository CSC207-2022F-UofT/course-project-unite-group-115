package general_group.interface_adapters;

public class GenGroupCreationFailed extends RuntimeException{

    /**
     * Creates an error with the message <errorMessage>. Should be used when a group has failed to be created.
     * @param error a String describing the error that occurred
     */
    public GenGroupCreationFailed(String error) {
        super(error);
    }
}
