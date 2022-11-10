package random_grouper_create.interface_adapters;

public class GroupCreationFailed extends RuntimeException {
    public GroupCreationFailed(String errorMessage) {
        super(errorMessage);
    }
}
