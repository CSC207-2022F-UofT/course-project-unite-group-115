package random_grouper_request_group.interface_adapters;

import random_grouper_request_group.application_business_rules.ReqRanGroupInputBoundary;
import random_grouper_request_group.application_business_rules.ReqRanGroupRequestModel;
import random_grouper_request_group.application_business_rules.ReqRanGroupResponseModel;

import java.util.List;

public class ReqRanGroupController {
    final ReqRanGroupInputBoundary USER_INPUT;


    public ReqRanGroupController(ReqRanGroupInputBoundary userInput) {
        this.USER_INPUT = userInput;
    }

    public ReqRanGroupResponseModel requestRanGroup(String userName) {
        ReqRanGroupRequestModel requestModel = new ReqRanGroupRequestModel(userName);
        return USER_INPUT.requestRanGroup(requestModel);
    }
}
