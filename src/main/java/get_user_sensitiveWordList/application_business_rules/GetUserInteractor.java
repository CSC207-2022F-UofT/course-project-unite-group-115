package get_user_sensitiveWordList.application_business_rules;

import Database.ProfileRepoInt;

import java.util.List;

public class GetUserInteractor implements GetUserSensitiveListInputBoundary{
    final GetUserSensitiveListOutputBoundary GET_List_OUTPUT_BOUNDARY;
    final ProfileRepoInt PROFILE_REPO_ACCESS;

    public GetUserInteractor(GetUserSensitiveListOutputBoundary getUserSensitiveOutputBoundary,
                                      ProfileRepoInt profileRepoAccess){
        this.GET_List_OUTPUT_BOUNDARY = getUserSensitiveOutputBoundary;
        this.PROFILE_REPO_ACCESS = profileRepoAccess;
    }

    /**
     * Get a user's interests.
     *
     * @param requestModel A data structure containing user's name
     * @return Returns a data structure containing the user's sensitiveWord List.
     */
    @Override
    public GetUserListResponseModel getUserSensWordList(GetUserListRequestModel requestModel) {
        List<String> SensList = PROFILE_REPO_ACCESS.getSensitiveWords(requestModel.getUsername());
        return new GetUserListResponseModel(SensList);
    }
}