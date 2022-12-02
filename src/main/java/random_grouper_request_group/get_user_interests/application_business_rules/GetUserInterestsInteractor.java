package random_grouper_request_group.get_user_interests.application_business_rules;

import database_classes.ProfileRepoInt;
import random_grouper_request_group.get_user_interests.interface_adapters.GetUserInterestsFailure;

import java.util.List;

public class GetUserInterestsInteractor implements GetUserInterestsInputBoundary {
    final GetUserInterestsOutputBoundary GET_INTERESTS_OUTPUT_BOUNDARY;
    final ProfileRepoInt PROFILE_REPO_ACCESS;

    public GetUserInterestsInteractor(GetUserInterestsOutputBoundary getUserInterestsOutputBoundary,
                                      ProfileRepoInt profileRepoAcces) {
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
        if (PROFILE_REPO_ACCESS.existsByName(requestModel.getUsername())) {
            List<String> interests = PROFILE_REPO_ACCESS.getInterests(requestModel.getUsername());
            return new GetUserInterestsResponseModel(interests);
        } else {
            throw new GetUserInterestsFailure("User not found.");
        }
    }
}
