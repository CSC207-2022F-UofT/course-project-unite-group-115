package get_user_sensitiveWordList.interface_adapters;

import get_user_sensitiveWordList.application_business_rules.GetUserListRequestModel;
import get_user_sensitiveWordList.application_business_rules.GetUserListResponseModel;
import get_user_sensitiveWordList.application_business_rules.GetUserSensitiveListInputBoundary;

public class GetUserSenListController {
    final GetUserSensitiveListInputBoundary USER_INPUT;

    public GetUserSenListController(GetUserSensitiveListInputBoundary userInput){
        this.USER_INPUT = userInput;
    }

    public GetUserListResponseModel getUserSensWordList(String username){
        GetUserListRequestModel requestModel = new GetUserListRequestModel(username);
        return USER_INPUT.getUserSensWordList(requestModel);

    }
}

