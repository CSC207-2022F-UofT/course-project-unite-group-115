package random_grouper_request_group.interface_adapters;

import random_grouper_request_group.application_business_rules.ReqRanGroupOutputBoundary;
import random_grouper_request_group.application_business_rules.ReqRanGroupResponseModel;

public class ReqRanGroupPresenter implements ReqRanGroupOutputBoundary {

    @Override
    public ReqRanGroupResponseModel prepareSuccessView(ReqRanGroupResponseModel group) {
        String groupID = group.getAddedToGroupID();
        String groupName = group.getAddedToGroupName();
        group.setSuccessMessage("You were successfully added to " + groupName + " (ID: " + groupID + ")!");
        return group;
    }

    @Override
    public ReqRanGroupResponseModel prepareFailView(String errorMessage) {
        throw new GroupAdditionFailed(errorMessage);
    }

    public String getSuccessMessage(ReqRanGroupResponseModel group) {
        return group.getSuccessMessage();
    }
}
