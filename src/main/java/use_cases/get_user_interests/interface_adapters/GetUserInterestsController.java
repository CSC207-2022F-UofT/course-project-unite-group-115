package use_cases.get_user_interests.interface_adapters;

import use_cases.get_user_interests.application_business_rules.GetUserInterestsInputBoundary;
import use_cases.get_user_interests.application_business_rules.GetUserInterestsRequestModel;
import use_cases.get_user_interests.application_business_rules.GetUserInterestsResponseModel;

public class GetUserInterestsController {
    final GetUserInterestsInputBoundary USER_INPUT;

    public GetUserInterestsController(GetUserInterestsInputBoundary userInput){
        this.USER_INPUT = userInput;
    }

    public GetUserInterestsResponseModel getUserInterests(String username){
        GetUserInterestsRequestModel requestModel = new GetUserInterestsRequestModel(username);
        return USER_INPUT.getUserInterests(requestModel);
    }
}
