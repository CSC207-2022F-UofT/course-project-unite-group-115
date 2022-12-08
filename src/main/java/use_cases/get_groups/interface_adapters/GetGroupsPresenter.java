package use_cases.get_groups.interface_adapters;

import use_cases.get_groups.application_business_rules.GetGroupsOutputBoundary;
import use_cases.get_groups.application_business_rules.GetGroupsResponseModel;
import use_cases.get_user_interests.interface_adapters.GetUserInterestsFailure;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetGroupsPresenter implements GetGroupsOutputBoundary {

    /**
     * Formats the information stored in the GetGroupsResponseModel data structure.
     *
     * @param response the GetGroupsResponseModel returned by the interactor
     * @return returns a formatted GetGroupsResponseModel
     */
    @Override
    public GetGroupsResponseModel prepareSuccessView(GetGroupsResponseModel response) {
        List<String> groups = new ArrayList<>(response.getGroupNames());
        Collections.sort(groups);
        response.setGroupNames(groups);
        return response;
    }

    @Override
    public GetGroupsResponseModel prepareFailView(String error) {
        throw new GetUserInterestsFailure(error);
    }
}
