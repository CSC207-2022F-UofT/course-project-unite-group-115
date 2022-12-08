package use_cases.get_user_sensitiveWordList.interface_adapters;

import use_cases.get_user_sensitiveWordList.application_business_rules.GetUserSensListRequestModel;
import use_cases.get_user_sensitiveWordList.application_business_rules.GetUserSensListResponseModel;
import use_cases.get_user_sensitiveWordList.application_business_rules.GetUserSensitiveListInputBoundary;

public class GetUserSenListController {
    final GetUserSensitiveListInputBoundary USER_INPUT;

    public GetUserSenListController(GetUserSensitiveListInputBoundary userInput){
        this.USER_INPUT = userInput;
    }

    public GetUserSensListResponseModel getUserSensWordList(String username){
        GetUserSensListRequestModel requestModel = new GetUserSensListRequestModel(username);
        return USER_INPUT.getUserSensWordList(requestModel);

    }
}

