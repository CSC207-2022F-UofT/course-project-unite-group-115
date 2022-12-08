package use_cases.user_register.interface_adapters;

import use_cases.user_register.application_business_rules.UserRegisterRequestModel;
import use_cases.user_register.application_business_rules.UserRegisterInputBoundary;
import use_cases.user_register.application_business_rules.UserRegisterResponseModel;

// Interface adapters layer

public class UserRegisterController {
    final UserRegisterInputBoundary userInput;

    /**
     * Creates a controller containing information that the user inputted into the UI.
     * @param accountGateway the action requested by the UI and the required information for that action to be performed
     */
    public UserRegisterController(UserRegisterInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    /**
     * Creates a user using the information inputted by the user.
     * @param username the username of the user.
     * @param password1 the password for the user's account.
     * @param password2 the re-entered password for confirmation.
     * @return the output from the creation of the user.
     */
    public UserRegisterResponseModel create(String username, String password1, String password2) {
        UserRegisterRequestModel requestModel = new UserRegisterRequestModel(
                username, password1, password2);

        return userInput.create(requestModel);
    }
}
