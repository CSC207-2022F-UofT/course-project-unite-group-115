package random_grouper_request_group.interface_adapters;

import random_grouper_request_group.application_business_rules.ReqRanGroupInputBoundary;
import random_grouper_request_group.application_business_rules.ReqRanGroupRequestModel;
import random_grouper_request_group.application_business_rules.ReqRanGroupResponseModel;

import java.util.List;

public class ReqRanGroupController {
    final ReqRanGroupInputBoundary userInput;


    public ReqRanGroupController(ReqRanGroupInputBoundary userInput) {
        this.userInput = userInput;
    }

    public ReqRanGroupResponseModel requestRanGroup(String userName, List<String> userInterests,
                                                    List<String> idsOfCurrentGroups) {
        ReqRanGroupRequestModel requestModel = new ReqRanGroupRequestModel(userName, userInterests, idsOfCurrentGroups);
        return userInput.requestRanGroup(requestModel);
    }
}
