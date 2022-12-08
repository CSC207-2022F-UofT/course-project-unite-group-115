package use_cases.random_grouper_request_group.interface_adapters;

import use_cases.random_grouper_request_group.application_business_rules.ReqRanGroupInputBoundary;
import use_cases.random_grouper_request_group.application_business_rules.ReqRanGroupRequestModel;
import use_cases.random_grouper_request_group.application_business_rules.ReqRanGroupResponseModel;


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
     * @return the result of requesting a random group
     */
    public ReqRanGroupResponseModel requestRanGroup(String userName) {
        ReqRanGroupRequestModel requestModel = new ReqRanGroupRequestModel(userName);
        return USER_INPUT.requestRanGroup(requestModel);
    }
}
