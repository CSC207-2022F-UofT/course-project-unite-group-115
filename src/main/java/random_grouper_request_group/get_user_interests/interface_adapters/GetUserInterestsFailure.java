package random_grouper_request_group.get_user_interests.interface_adapters;

public class GetUserInterestsFailure extends RuntimeException {
    public GetUserInterestsFailure(String errorMessage) {
        super(errorMessage);
    }
}
