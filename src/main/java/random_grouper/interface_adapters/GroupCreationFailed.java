package random_grouper.interface_adapters;

public class GroupCreationFailed extends RuntimeException {
    public GroupCreationFailed(String errorMessage) {
        super(errorMessage);
    }
}
