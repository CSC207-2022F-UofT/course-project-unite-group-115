package general_group.interface_adapters;

import general_group.entities.User;
import general_group.use_case.GeneralGroupCreateDsRequestModel;
import general_group.use_case.GeneralGroupCreateDsResponseModel;
import general_group.use_case.GeneralGroupCreateInputBoundary;

import java.util.List;

public class GeneralGroupCreateController {
    final GeneralGroupCreateInputBoundary inputBoundary;

    public GeneralGroupCreateController(GeneralGroupCreateInputBoundary inputBoundary) {
        this.inputBoundary = inputBoundary;
    }

    GeneralGroupCreateDsResponseModel create(String groupName, List<User> friendsToAdd, String groupCreatorName) {
        GeneralGroupCreateDsRequestModel requestModel = new GeneralGroupCreateDsRequestModel(groupName, friendsToAdd,
                groupCreatorName);

        return inputBoundary.create(requestModel);
    }

}
