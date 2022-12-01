package get_friends.interface_adapters;

import get_friends.entities.Profile;
import get_friends.use_case.GetFriendsInputBoundary;
import get_friends.use_case.GetFriendsDsRequestModel;
import get_friends.use_case.GetFriendsDsResponseModel;

public class GetFriendsController {
    final GetFriendsInputBoundary userInput;

    public GetFriendsController(GetFriendsInputBoundary userInput) {
        this.userInput = userInput;
    }

    public GetFriendsDsResponseModel getFriendsList(Profile userProfile) {
        GetFriendsDsRequestModel requestModel = new GetFriendsDsRequestModel(userProfile);

        return userInput.getFriendsList(requestModel);
    }


}
