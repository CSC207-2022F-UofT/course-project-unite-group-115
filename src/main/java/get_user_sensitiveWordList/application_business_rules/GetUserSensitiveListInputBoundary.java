package get_user_sensitiveWordList.application_business_rules;

import add_blocked_Users.application_business_rules.AddBlockedUserRequestModel;

public interface GetUserSensitiveListInputBoundary {


    /**
     * Get a user's list.
     *
     * @param requestModel A data structure containing user's name
     * @return Returns a data structure containing the user's interests.
     */
    GetUserListResponseModel getUserSensWordList(GetUserListRequestModel requestModel);




}