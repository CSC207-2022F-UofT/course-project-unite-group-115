package use_cases.add_blocked_users.Interface_adapters;

import use_cases.add_blocked_users.application_business_rules.AddBlockedUserRequestModel;
import use_cases.add_blocked_users.application_business_rules.AddBlockedUserResponseModel;
import use_cases.add_blocked_users.application_business_rules.AddblockedUserInputBoundary;

public class AddBlockedUserController {
    final AddblockedUserInputBoundary USER_INPUT;

    public AddBlockedUserController(AddblockedUserInputBoundary userInput){
        this.USER_INPUT = userInput;
    }

    public AddBlockedUserResponseModel AddBlockedUser(String username, String blockedname){
        AddBlockedUserRequestModel requestModel = new AddBlockedUserRequestModel(username,blockedname);
        return USER_INPUT.AddBlockedUser(requestModel);

    }

}
