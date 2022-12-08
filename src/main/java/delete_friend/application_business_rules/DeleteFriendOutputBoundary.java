package delete_friend.application_business_rules;

public interface DeleteFriendOutputBoundary {
    DeleteFriendResponseModel prepareSuccessView(DeleteFriendResponseModel responseModel);
    DeleteFriendResponseModel prepareFailView(String errorMessage);
}
