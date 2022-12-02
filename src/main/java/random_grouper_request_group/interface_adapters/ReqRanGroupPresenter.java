package random_grouper_request_group.interface_adapters;

import random_grouper_request_group.application_business_rules.ReqRanGroupOutputBoundary;
import random_grouper_request_group.application_business_rules.ReqRanGroupResponseModel;

public class ReqRanGroupPresenter implements ReqRanGroupOutputBoundary {
    /**
     * Format the successful result of requesting a random group.
     * @param group the response model created by the interactor
     * @return the formatted response model
     */
    @Override
    public ReqRanGroupResponseModel prepareSuccessView(ReqRanGroupResponseModel group) {
        String groupID = group.getAddedToGroupID();
        String groupName = group.getAddedToGroupName();
        group.setSuccessMessage("You were successfully added to " + groupName + " (ID: " + groupID + ")!");
        return group;
    }

    /**
     * Throws an error that contains an <errorMessage> that describes the error that occurred.
     * @param errorMessage a String describing the error that occurred.
     */
    @Override
    public ReqRanGroupResponseModel prepareFailView(String errorMessage) {
        throw new GroupAdditionFailure(errorMessage);
    }

    /**
     * Returns the success message that was created when the user was added to a random group.
     * @param group the response model created by the interactor
     */
    @Override
    public String getSuccessMessage(ReqRanGroupResponseModel group) {
        return group.getSuccessMessage();
    }
}
