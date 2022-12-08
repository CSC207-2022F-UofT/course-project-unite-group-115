package use_cases.random_grouper_request_group.interface_adapters;

public class GroupAdditionFailure extends RuntimeException {
    /**
     * Creates an error with the message <errorMessage>. Should be used when a User has failed to be added to a random
     * group.
     * @param errorMessage a String describing the error that occurred
     */
    public GroupAdditionFailure(String errorMessage){
        super(errorMessage);
    }
}
