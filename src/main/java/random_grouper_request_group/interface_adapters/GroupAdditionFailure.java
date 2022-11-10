package random_grouper_request_group.interface_adapters;

public class GroupAdditionFailure extends RuntimeException {
    public GroupAdditionFailure(String errorMessage){
        super(errorMessage);
    }
}
