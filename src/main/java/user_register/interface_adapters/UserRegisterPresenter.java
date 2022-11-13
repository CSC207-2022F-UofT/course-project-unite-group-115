package user_register.interface_adapters;

import user_register.application_business_rules.UserRegisterOutputBoundary;
import user_register.application_business_rules.UserRegisterResponseModel;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class UserRegisterPresenter implements UserRegisterOutputBoundary {
    @Override
    public UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel user) {
        return new UserRegisterResponseModel("###", "###");
    };

    public UserRegisterResponseModel prepareFailView(String error){
        return new UserRegisterResponseModel("###", "###");
    }
}
