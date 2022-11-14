package random_grouper_request_group.interface_adapters;

import random_grouper_request_group.application_business_rules.ReqRanGroupInputBoundary;
import random_grouper_request_group.application_business_rules.ReqRanGroupRequestModel;
import random_grouper_request_group.application_business_rules.ReqRanGroupResponseModel;

import java.util.List;

public class ReqRanGroupController {
    final ReqRanGroupInputBoundary USER_INPUT;

    /**
     * Creates a controller containing information that the user inputted into the UI.
     * @param userInput the action requested by the UI and the required information for that action to be performed
     */
    public ReqRanGroupController(ReqRanGroupInputBoundary userInput) {
        this.USER_INPUT = userInput;
    }

    /**
     * Requests a random group using the information about the user.
     * @param userName the user's name
     * @param userInterests the user's interests
     * @param idsOfCurrentGroups the IDs of the current groups the user is apart of
     * @return the result of requesting a random group
     */
    public ReqRanGroupResponseModel requestRanGroup(String userName, List<String> userInterests,
                                                    List<String> idsOfCurrentGroups) {
        ReqRanGroupRequestModel requestModel = new ReqRanGroupRequestModel(userName, userInterests, idsOfCurrentGroups);
        return USER_INPUT.requestRanGroup(requestModel);
    }
}
