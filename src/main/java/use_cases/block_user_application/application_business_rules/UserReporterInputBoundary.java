package use_cases.block_user_application.application_business_rules;

public interface UserReporterInputBoundary {


    UserReporterResponseModel create(UserReporterRequestModel requestModel);
}
