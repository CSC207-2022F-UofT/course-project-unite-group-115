package random_grouper_create.application_business_rules;

import databases.ProfileRepoInt;

import java.util.List;

public class GetUserInterestsInteractor implements GetUserInterestsInputBoundary{
    final GetUserInterestsOutputBoundary GET_INTERESTS_OUTPUT_BOUNDARY;
    final ProfileRepoInt PROFILE_REPO_ACCESS;

    public GetUserInterestsInteractor(GetUserInterestsOutputBoundary getUserInterestsOutputBoundary,
                               ProfileRepoInt profileRepoAcces){
        this.GET_INTERESTS_OUTPUT_BOUNDARY = getUserInterestsOutputBoundary;
        this.PROFILE_REPO_ACCESS = profileRepoAcces;
    }

    /**
     * Get a user's interests.
     *
     * @param requestModel A data structure containing user's name
     * @return Returns a data structure containing the user's interests.
     */
    @Override
    public GetUserInterestsResponseModel getUserInterests(GetUserInterestsRequestModel requestModel) {
        List<String> interests = PROFILE_REPO_ACCESS.getInterests(requestModel.getUsername());
        return new GetUserInterestsResponseModel(interests);
    }
}
