package user_register.interface_adapters;

import user_register.application_business_rules.UserRegisterOutputBoundary;
import user_register.application_business_rules.UserRegisterResponseModel;
import user_register.frameworks_and_drivers.UserCreationFailed;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserRegisterPresenter implements UserRegisterOutputBoundary {
    @Override
    public UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    public UserRegisterResponseModel prepareFailView(String error){
        throw new UserCreationFailed(error);
//        return new UserRegisterResponseModel("###", "###");
    }
}
