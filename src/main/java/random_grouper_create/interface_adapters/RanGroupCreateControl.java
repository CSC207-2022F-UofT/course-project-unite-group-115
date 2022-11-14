package random_grouper_create.interface_adapters;

import random_grouper_create.application_business_rules.RanGroupCreateInputBoundary;
import random_grouper_create.application_business_rules.RanGroupCreateRequestModel;
import random_grouper_create.application_business_rules.RanGroupCreateResponseModel;

import java.util.List;

public class RanGroupCreateControl {
    final RanGroupCreateInputBoundary USER_INPUT;

    /**
     * Creates a controller containing information that the user inputted into the UI.
     * @param userInput the action requested by the UI and the required information for that action to be performed
     */
    public RanGroupCreateControl(RanGroupCreateInputBoundary userInput) {
        this.USER_INPUT = userInput;
    }

    /**
     *
     * @param groupName the name of the group
     * @param interests a List of interests for the group
     * @param groupCreatorName the name of the User that created the group
     * @return the output from the creation of the group
     */
    public RanGroupCreateResponseModel createGroup(String groupName, List<String> interests, String groupCreatorName){
        RanGroupCreateRequestModel requestModel =
                new RanGroupCreateRequestModel(groupName, interests, groupCreatorName);

        return USER_INPUT.createRanGroup(requestModel);
    }
}
