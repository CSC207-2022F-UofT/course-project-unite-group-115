package add_blocked_Users.Interface;

import Database.InputBoundary;
import Database.UserMessageModel;
import Database.UserMessageResponseModel;
import add_blocked_Users.application_business_rules.AddBlockedUserRequestModel;
import add_blocked_Users.application_business_rules.AddBlockedUserResponseModel;
import add_blocked_Users.application_business_rules.AddblockedUserInputBoundary;
import get_user_sensitiveWordList.application_business_rules.GetUserListRequestModel;
import get_user_sensitiveWordList.application_business_rules.GetUserListResponseModel;
import get_user_sensitiveWordList.application_business_rules.GetUserSensitiveListInputBoundary;

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
