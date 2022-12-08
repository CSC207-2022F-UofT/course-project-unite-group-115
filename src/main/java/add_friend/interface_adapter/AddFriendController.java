package add_friend.interface_adapter;


import add_friend.application_business_rules.AddFriendInputBoundary;
import add_friend.application_business_rules.AddFriendRequestModel;
import add_friend.application_business_rules.AddFriendResponseModel;

public class AddFriendController {
    final AddFriendInputBoundary userInput;


    public AddFriendController(AddFriendInputBoundary userInput) {
        this.userInput = userInput;
    }

    public AddFriendResponseModel addFriend(String loggedInUser, String friendUsername){
        AddFriendRequestModel requestModel = new AddFriendRequestModel(loggedInUser, friendUsername);
        return userInput.addFriend(requestModel);
    }
}
