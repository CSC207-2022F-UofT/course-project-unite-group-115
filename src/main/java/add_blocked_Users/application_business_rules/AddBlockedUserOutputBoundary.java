package add_blocked_Users.application_business_rules;

public interface AddBlockedUserOutputBoundary {
    AddBlockedUserResponseModel prepareSuccessView(AddBlockedUserResponseModel response);
    AddBlockedUserResponseModel prepareFailView(String error);
}