package add_blocked_Users.application_business_rules;

import get_user_sensitiveWordList.application_business_rules.GetUserListResponseModel;

public interface AddBlockedUserOutputBoundary {
    AddBlockedUserResponseModel prepareSuccessView(AddBlockedUserResponseModel response);
    AddBlockedUserResponseModel prepareFailView(String error);
}
