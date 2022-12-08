package use_cases.block_user_application.application_business_rules;

public interface UserReporterOutputBoundary {
    UserReporterResponseModel prepareSuccessView(UserReporterResponseModel user);

    UserReporterResponseModel prepareFailView(String error);
}

