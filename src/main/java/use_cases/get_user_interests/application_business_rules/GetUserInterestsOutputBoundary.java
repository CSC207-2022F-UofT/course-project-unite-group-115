package use_cases.get_user_interests.application_business_rules;

public interface GetUserInterestsOutputBoundary {
    /**
     * Formats the information stored in the GetUserInterestsResponseModel data structure.
     * @param response the GetUserInterestsReponseModel returned by the interactor
     * @return returns a formatted GetUserInterestsReponseModel
     */
    GetUserInterestsResponseModel prepareSuccessView(GetUserInterestsResponseModel response);

    GetUserInterestsResponseModel prepareFailView(String error);
}
