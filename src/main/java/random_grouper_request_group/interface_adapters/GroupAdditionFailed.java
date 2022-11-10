package random_grouper_request_group.interface_adapters;

public class GroupAdditionFailed extends RuntimeException {
    public GroupAdditionFailed(String errorMessage){
        super(errorMessage);
    }
}
