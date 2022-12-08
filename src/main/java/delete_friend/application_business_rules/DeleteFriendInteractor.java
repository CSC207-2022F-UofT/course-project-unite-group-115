package delete_friend.application_business_rules;

import delete_friend.interface_adapter.DeleteFriendFailure;
import database_classes.ProfileRepoInt;

import java.util.List;

public class DeleteFriendInteractor implements DeleteFriendInputBoundary{
    final ProfileRepoInt profileData;
    final DeleteFriendOutputBoundary deleteFriendOutputBoundary;

    public DeleteFriendInteractor(ProfileRepoInt profileData, DeleteFriendOutputBoundary deleteFriendOutputBoundary){
        this.profileData = profileData;
        this.deleteFriendOutputBoundary = deleteFriendOutputBoundary;
    }

    @Override
    public DeleteFriendResponseModel deleteFriend(DeleteFriendRequestModel requestModel) {
        String username = requestModel.getLoggedInUser();
        String friend = requestModel.getFriendUsername();

        if (profileData.existsByName(username)) {
            List<String> currentFriends = profileData.getFriends(username);
            if (username.equals(friend)){
                throw new DeleteFriendFailure("You can't delete yourself!");
            }
            else if (!currentFriends.contains(friend)){
                throw new DeleteFriendFailure(friend + " is not your friend");
            }
            profileData.removeFriendFromProfile(username, friend);
            profileData.removeFriendFromProfile(friend, username);
        } else {
            throw new DeleteFriendFailure("Logged in user does not have a profile.");
        }

        return new DeleteFriendResponseModel(friend, "success");
    }
}
