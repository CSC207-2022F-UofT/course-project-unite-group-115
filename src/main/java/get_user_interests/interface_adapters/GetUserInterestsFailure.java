package get_user_interests.interface_adapters;

public class GetUserInterestsFailure extends RuntimeException {
    public GetUserInterestsFailure(String errorMessage) {
        super(errorMessage);
    }
}
