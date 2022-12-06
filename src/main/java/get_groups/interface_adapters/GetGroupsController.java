package get_groups.interface_adapters;

import get_groups.application_business_rules.GetGroupsInputBoundary;
import get_groups.application_business_rules.GetGroupsRequestModel;
import get_groups.application_business_rules.GetGroupsResponseModel;

public class GetGroupsController {
    final GetGroupsInputBoundary USER_INPUT;

    public GetGroupsController(GetGroupsInputBoundary userInput){
            this.USER_INPUT = userInput;
        }

        public GetGroupsResponseModel getUsersGroups(String username){
            GetGroupsRequestModel requestModel = new GetGroupsRequestModel(username);
            return USER_INPUT.getUsersGroups(requestModel);
        }
    }
