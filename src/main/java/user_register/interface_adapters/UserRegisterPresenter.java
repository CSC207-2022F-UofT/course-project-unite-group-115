package user_register.interface_adapters;

import screens.UserCreationFailed;
import user_register.application_business_rules.UserRegisterOutputBoundary;
import user_register.application_business_rules.UserRegisterResponseModel;
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
    }
}
