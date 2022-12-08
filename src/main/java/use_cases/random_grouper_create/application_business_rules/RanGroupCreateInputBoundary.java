package use_cases.random_grouper_create.application_business_rules;

public interface RanGroupCreateInputBoundary {
    /**
     * Create a new random group and save it to the GroupDatabase. The User that creates the group will be
     * automatically considered a member.
     * @param requestModel A data structure containing the new group's name and selected interests, as well as the
     *                     name of the group's creator
     * @return Returns a data structure containing the group's name and creation time, if the creation was successful.
     * Or returns a data structure containing a failure message, if the creation was unsuccessful.
     */
    RanGroupCreateResponseModel createRanGroup(RanGroupCreateRequestModel requestModel);
}
