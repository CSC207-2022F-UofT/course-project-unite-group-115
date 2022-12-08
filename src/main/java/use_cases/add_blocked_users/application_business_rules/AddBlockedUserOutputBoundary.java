package use_cases.add_blocked_users.application_business_rules;

public interface AddBlockedUserOutputBoundary {
    AddBlockedUserResponseModel prepareSuccessView(AddBlockedUserResponseModel response);
    AddBlockedUserResponseModel prepareFailView(String error);
}