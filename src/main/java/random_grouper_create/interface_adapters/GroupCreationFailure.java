package random_grouper_create.interface_adapters;

public class GroupCreationFailure extends RuntimeException {
    public GroupCreationFailure(String errorMessage) {
        super(errorMessage);
    }
}
