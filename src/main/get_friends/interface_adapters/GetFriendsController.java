package get_friends.interface_adapters;

import get_friends.entities.Profile;
import get_friends.use_case.GetFriendsInputBoundary;
import get_friends.use_case.GetFriendsRequestModel;
import get_friends.use_case.GetFriendsDsResponseModel;

public class GetFriendsController {
    final GetFriendsInputBoundary userInput;

    public GetFriendsController(GetFriendsInputBoundary userInput) {
        this.userInput = userInput;
    }

    GetFriendsDsResponseModel getFriendsList(Profile userProfile) {
        GetFriendsRequestModel requestModel = new GetFriendsRequestModel(userProfile);

        return userInput.getFriendsList(requestModel);
    }


}
