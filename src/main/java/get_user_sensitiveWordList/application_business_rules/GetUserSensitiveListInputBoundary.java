package get_user_sensitiveWordList.application_business_rules;

public interface GetUserSensitiveListInputBoundary {


    /**
     * Get a user's list.
     *
     * @param requestModel A data structure containing user's name
     * @return Returns a data structure containing the user's WordList.
     */
    GetUserSensListResponseModel getUserSensWordList(GetUserSensListRequestModel requestModel);

}