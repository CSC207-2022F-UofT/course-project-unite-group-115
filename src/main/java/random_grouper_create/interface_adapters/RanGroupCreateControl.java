package random_grouper_create.interface_adapters;

import random_grouper_create.application_business_rules.RanGroupCreateInputBoundary;
import random_grouper_create.application_business_rules.RanGroupCreateRequestModel;
import random_grouper_create.application_business_rules.RanGroupCreateResponseModel;

import java.util.List;

public class RanGroupCreateControl {
    final RanGroupCreateInputBoundary USER_INPUT;

    public RanGroupCreateControl(RanGroupCreateInputBoundary userInput) {
        this.USER_INPUT = userInput;
    }

    // ToDo: Make return void?
    public RanGroupCreateResponseModel createGroup(String groupName, List<String> interests, String groupCreatorName){
        RanGroupCreateRequestModel requestModel =
                new RanGroupCreateRequestModel(groupName, interests, groupCreatorName);

        return USER_INPUT.createRanGroup(requestModel);
    }
}
