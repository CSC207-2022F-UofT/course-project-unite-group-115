package add_blocked_Users.application_business_rules;

import Database.ProfileRepoInt;
import add_blocked_Users.Interface.Failure;
import get_user_sensitiveWordList.application_business_rules.GetUserListRequestModel;
import get_user_sensitiveWordList.application_business_rules.GetUserListResponseModel;
import get_user_sensitiveWordList.application_business_rules.GetUserSensitiveListOutputBoundary;

import java.util.List;

public class blockedUserInteractor implements AddblockedUserInputBoundary{
    final AddBlockedUserOutputBoundary GET_List_OUTPUT_BOUNDARY;
    final ProfileRepoInt PROFILE_REPO_ACCESS;

    public blockedUserInteractor(AddBlockedUserOutputBoundary addBlockedUserOutputBoundary,
                             ProfileRepoInt profileRepoAccess){
        this.GET_List_OUTPUT_BOUNDARY = addBlockedUserOutputBoundary;
        this.PROFILE_REPO_ACCESS = profileRepoAccess;
    }

    /**
     * Get a user's interests.
     *
     * @param requestModel A data structure containing user's name
     * @return Returns a data structure containing the user's sensitiveWord List.
     */
    @Override
    public  AddBlockedUserResponseModel AddBlockedUser(AddBlockedUserRequestModel requestModel) {
        if (PROFILE_REPO_ACCESS.existsByName(requestModel.getUsername())) {
            PROFILE_REPO_ACCESS.addBlockedUserToProfile(requestModel.getUsername(), requestModel.getBlockedName());
            List<String> list = PROFILE_REPO_ACCESS.getBlockedUser(requestModel.getUsername());
            return new AddBlockedUserResponseModel(list);
        } else {
            throw new Failure("User not found.");
        }
    }
}
