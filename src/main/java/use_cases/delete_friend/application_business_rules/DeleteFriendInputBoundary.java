package use_cases.delete_friend.application_business_rules;

public interface DeleteFriendInputBoundary {
    DeleteFriendResponseModel deleteFriend(DeleteFriendRequestModel requestModel);
}
