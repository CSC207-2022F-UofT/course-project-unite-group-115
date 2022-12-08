package get_user_sensitiveWordList.application_business_rules;

public interface GetUserSensitiveListOutputBoundary {
    GetUserSensListResponseModel prepareSuccessView(GetUserSensListResponseModel response);
    GetUserSensListResponseModel prepareFailView(String error);
}
