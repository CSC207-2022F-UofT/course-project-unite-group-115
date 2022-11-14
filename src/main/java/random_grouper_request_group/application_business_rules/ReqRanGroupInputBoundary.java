package random_grouper_request_group.application_business_rules;

public interface ReqRanGroupInputBoundary {
    /**
     * Try to add User to a random group. The User will be added to the random group that has the most interests in
     * common with them. If no existing random groups have any interests in common with the User, the User will not
     * be added to a group.
     * @param requestModel the information required to attempt to add the User to a random group
     * @return the result of trying to add the User to a random group
     */
    ReqRanGroupResponseModel requestRanGroup(ReqRanGroupRequestModel requestModel);
}
