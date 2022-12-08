package use_cases.add_friend.application_business_rules;

public interface AddFriendInputBoundary {
    AddFriendResponseModel addFriend(AddFriendRequestModel requestModel);
}
