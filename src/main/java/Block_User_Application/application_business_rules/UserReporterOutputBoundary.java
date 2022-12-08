package Block_User_Application.application_business_rules;

public interface UserReporterOutputBoundary {
    UserReporterResponseModel prepareSuccessView(UserReporterResponseModel user);

    UserReporterResponseModel prepareFailView(String error);
}

