package get_user_sensitiveWordList.application_business_rules;

public interface GetUserSensitiveListOutputBoundary {
    GetUserListResponseModel prepareSuccessView(GetUserListResponseModel response);
    GetUserListResponseModel prepareFailView(String error);
}
