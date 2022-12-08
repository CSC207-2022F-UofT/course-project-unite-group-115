package delete_friend.interface_adapter;

import delete_friend.application_business_rules.DeleteFriendInputBoundary;
import delete_friend.application_business_rules.DeleteFriendRequestModel;
import delete_friend.application_business_rules.DeleteFriendResponseModel;

public class DeleteFriendController {
    final DeleteFriendInputBoundary userInput;

    public DeleteFriendController(DeleteFriendInputBoundary userInput) {
        this.userInput = userInput;
    }

    public DeleteFriendResponseModel deleteFriend(String loggedInUser, String friendUsername){
        DeleteFriendRequestModel requestModel = new DeleteFriendRequestModel(loggedInUser, friendUsername);
        return userInput.deleteFriend(requestModel);
    }
}
