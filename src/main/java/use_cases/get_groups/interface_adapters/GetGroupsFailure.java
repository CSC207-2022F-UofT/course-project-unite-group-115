package use_cases.get_groups.interface_adapters;

public class GetGroupsFailure extends RuntimeException{
    public GetGroupsFailure(String errorMessage) {
        super(errorMessage);
    }
}
