package random_grouper_create.interface_adapters;

public class GroupCreationFailure extends RuntimeException {
    /**
     * Creates an error with the message <errorMessage>. Should be used when a group has failed to be created.
     * @param errorMessage a String describing the error that occurred
     */
    public GroupCreationFailure(String errorMessage) {
        super(errorMessage);
    }
}
