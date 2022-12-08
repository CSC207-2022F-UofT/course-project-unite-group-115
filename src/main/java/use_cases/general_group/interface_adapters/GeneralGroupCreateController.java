package use_cases.general_group.interface_adapters;

import use_cases.general_group.use_case.GeneralGroupCreateDsRequestModel;
import use_cases.general_group.use_case.GeneralGroupCreateDsResponseModel;
import use_cases.general_group.use_case.GeneralGroupCreateInputBoundary;

import java.util.List;

public class GeneralGroupCreateController {
    final GeneralGroupCreateInputBoundary inputBoundary;

    /**
     * Creates a controller containing information that the user inputted into the UI.
     * @param inputBoundary the action requested by the UI and the required information for that action to be performed
     */
    public GeneralGroupCreateController(GeneralGroupCreateInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    /**
     * Create a general group using the information given
     * @param groupName Name of group
     * @param friendsToAdd List of friends to add
     * @param groupCreatorName Name of the group creator
     * @return Output result of the creation of the group
     */
    public GeneralGroupCreateDsResponseModel create(String groupName, List<String> friendsToAdd, String groupCreatorName) {
        GeneralGroupCreateDsRequestModel requestModel = new GeneralGroupCreateDsRequestModel(groupName, friendsToAdd,
                groupCreatorName);

        return inputBoundary.create(requestModel);
    }

}
