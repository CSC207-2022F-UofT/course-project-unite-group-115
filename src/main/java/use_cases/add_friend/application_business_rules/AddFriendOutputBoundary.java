package use_cases.add_friend.application_business_rules;

public interface AddFriendOutputBoundary {
    AddFriendResponseModel prepareSuccessView(AddFriendResponseModel responseModel);

    AddFriendResponseModel prepareFailView(String errorMessage);
}
