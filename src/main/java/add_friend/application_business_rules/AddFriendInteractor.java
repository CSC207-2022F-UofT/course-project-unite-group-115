package add_friend.application_business_rules;

import database_classes.ProfileRepoInt;
import add_friend.interface_adapter.AddFriendFailure;

import java.util.List;

public class AddFriendInteractor implements AddFriendInputBoundary {
    final ProfileRepoInt profileData;
    final AddFriendOutputBoundary addFriendOutputBoundary;

    public AddFriendInteractor(ProfileRepoInt profileData, AddFriendOutputBoundary addFriendOutputBoundary) {
        this.profileData = profileData;
        this.addFriendOutputBoundary = addFriendOutputBoundary;
    }

    @Override
    public AddFriendResponseModel addFriend(AddFriendRequestModel requestModel) {
        String username = requestModel.getLoggedInUser();
        String friend = requestModel.getFriendUsername();
        if (profileData.existsByName(username)) {
            List<String> currentFriends = profileData.getFriends(username);
            if (!profileData.existsByName(friend)) {
                throw new AddFriendFailure("The user you requested does not exist or does not have" +
                        " a profile.");
            }
            else if (username.equals(friend)){
                throw new AddFriendFailure("You can't be friends with yourself!");
            }
            else if (currentFriends.contains(friend)){
                throw new AddFriendFailure("You are already friends with " + friend);
            }
            profileData.addFriendToProfile(username, friend);
            profileData.addFriendToProfile(friend, username);
        } else {
            throw new AddFriendFailure("Logged in user does not have a profile.");
        }

        return new AddFriendResponseModel(friend, "success");
    }
}
