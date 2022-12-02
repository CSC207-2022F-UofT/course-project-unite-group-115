package user_register.interface_adapters;

import user_register.application_business_rules.UserRegisterInputBoundary;
import user_register.application_business_rules.UserRegisterRequestModel;
import user_register.application_business_rules.UserRegisterResponseModel;

// Interface adapters layer

public class UserRegisterController {

    final UserRegisterInputBoundary userInput;

    public UserRegisterController(UserRegisterInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public UserRegisterResponseModel create(String username, String password1, String password2) {
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                username, password1, password2);

        return userInput.create(requestModel);
    }
}
