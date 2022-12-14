package use_cases.get_friends.interface_adapters;

import use_cases.get_friends.use_case.GetFriendsInputBoundary;
import use_cases.get_friends.use_case.GetFriendsDsRequestModel;
import use_cases.get_friends.use_case.GetFriendsDsResponseModel;

public class GetFriendsController {
    final GetFriendsInputBoundary userInput;
    public GetFriendsController(GetFriendsInputBoundary userInput) {
        this.userInput = userInput;
    }

    /**
     * Uses userProfile to retrieve the friend's list
     * @param username The name of the user
     * @return List of friends
     */
    public GetFriendsDsResponseModel getFriendsList(String username) {
        GetFriendsDsRequestModel requestModel = new GetFriendsDsRequestModel(username);

        return userInput.getFriendsList(requestModel);
    }


}
