package use_cases.get_user_sensitiveWordList.application_business_rules;

import database_classes.ProfileRepoInt;
import use_cases.get_user_sensitiveWordList.interface_adapters.GetUserSenListFailure;

import java.util.List;

public class GetUserSensWordListInteractor implements GetUserSensitiveListInputBoundary{
    final GetUserSensitiveListOutputBoundary GET_List_OUTPUT_BOUNDARY;
    final ProfileRepoInt PROFILE_REPO_ACCESS;

    public GetUserSensWordListInteractor(GetUserSensitiveListOutputBoundary getUserSensitiveOutputBoundary,
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
    public GetUserSensListResponseModel getUserSensWordList(GetUserSensListRequestModel requestModel) {
        if (PROFILE_REPO_ACCESS.existsByName(requestModel.getUsername())) {
            List<String> SensList = PROFILE_REPO_ACCESS.getSensitiveWords(requestModel.getUsername());
            return new GetUserSensListResponseModel(SensList);
        } else {
            throw new GetUserSenListFailure("User not found.");
        }
    }
}
