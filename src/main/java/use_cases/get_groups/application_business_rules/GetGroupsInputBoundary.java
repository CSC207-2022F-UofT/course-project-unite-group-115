package use_cases.get_groups.application_business_rules;

public interface GetGroupsInputBoundary {
    /**
     * Get a user's current groups, including the groups' name and ID.
     * @param requestModel A data structure containing user's name
     * @return Returns a data structure containing the user's interests.
     */
    GetGroupsResponseModel getUsersGroups(GetGroupsRequestModel requestModel);
}
