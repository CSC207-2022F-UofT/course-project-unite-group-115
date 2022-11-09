package random_grouper.interface_adapters;

import random_grouper.application_business_rules.RanGroupCreateInputBoundary;
import random_grouper.application_business_rules.RanGroupCreateRequestModel;
import random_grouper.application_business_rules.RanGroupCreateResponseModel;

import java.util.List;

public class RanGroupCreateControl {
    final RanGroupCreateInputBoundary userInput;

    public RanGroupCreateControl(RanGroupCreateInputBoundary userInput) {
        this.userInput = userInput;
    }

    RanGroupCreateResponseModel createGroup(String groupName, List<String> interests, String groupCreatorName){
        RanGroupCreateRequestModel requestModel =
                new RanGroupCreateRequestModel(groupName, interests, groupCreatorName);

        return userInput.createRanGroup(requestModel);
    }
}
