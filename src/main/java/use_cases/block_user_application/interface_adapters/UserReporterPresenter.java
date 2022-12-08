package use_cases.block_user_application.interface_adapters;

import use_cases.block_user_application.application_business_rules.UserReporterOutputBoundary;
import use_cases.block_user_application.application_business_rules.UserReporterResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserReporterPresenter implements UserReporterOutputBoundary {
    @Override
    public UserReporterResponseModel prepareSuccessView(UserReporterResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getTime());
        response.setTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    public UserReporterResponseModel prepareFailView(String error){
        throw new UserReporterFailure(error);
    }

}
