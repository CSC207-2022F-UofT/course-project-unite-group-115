package use_cases.get_groups.application_business_rules;


public interface GetGroupsOutputBoundary {
    /**
     * Formats the information stored in the GetGroupsResponseModel data structure.
     * @param response the GetGroupsResponseModel returned by the interactor
     * @return returns a formatted GetGroupsResponseModel
     */
    GetGroupsResponseModel prepareSuccessView(GetGroupsResponseModel response);

    GetGroupsResponseModel prepareFailView(String error);
}
