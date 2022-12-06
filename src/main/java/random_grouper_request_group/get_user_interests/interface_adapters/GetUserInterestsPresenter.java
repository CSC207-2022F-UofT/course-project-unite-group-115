package random_grouper_request_group.get_user_interests.interface_adapters;

import random_grouper_request_group.get_user_interests.application_business_rules.GetUserInterestsOutputBoundary;
import random_grouper_request_group.get_user_interests.application_business_rules.GetUserInterestsResponseModel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetUserInterestsPresenter implements GetUserInterestsOutputBoundary {
    /**
     * Formats the information stored in the GetUserInterestsResponseModel data structure.
     *
     * @param response the GetUserInterestsReponseModel returned by the interactor
     * @return returns a formatted GetUserInterestsReponseModel
     */
    @Override
    public GetUserInterestsResponseModel prepareSuccessView(GetUserInterestsResponseModel response) {
        List <String> interests = new ArrayList<>(response.getInterests());
        Collections.sort(interests);
        response.setInterests(interests);
        return response;
    }

    @Override
    public GetUserInterestsResponseModel prepareFailView(String error) {
        throw new GetUserInterestsFailure(error);
    }
}
