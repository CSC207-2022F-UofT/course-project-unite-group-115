package add_blocked_Users.Interface;

import add_blocked_Users.application_business_rules.AddBlockedUserRequestModel;
import add_blocked_Users.application_business_rules.AddBlockedUserResponseModel;
import add_blocked_Users.application_business_rules.AddblockedUserInputBoundary;

public class BlockedController {
    final AddblockedUserInputBoundary USER_INPUT;

    public BlockedController(AddblockedUserInputBoundary userInput){
        this.USER_INPUT = userInput;
    }

    public AddBlockedUserResponseModel AddBlockedUser(String username, String blockedname){
        AddBlockedUserRequestModel requestModel = new AddBlockedUserRequestModel(username,blockedname);
        return USER_INPUT.AddBlockedUser(requestModel);

    }

}
