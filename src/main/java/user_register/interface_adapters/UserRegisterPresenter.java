package user_register.interface_adapters;

import user_register.application_business_rules.UserRegisterOutputBoundary;
import user_register.application_business_rules.UserRegisterResponseModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UserRegisterPresenter implements UserRegisterOutputBoundary {
    /**
     * Formats the information stored in the responseModel data structure
     * when group creation was successful.
     * @param response the responseModel returned by the interactor.
     * @return returns a formatted responseModel
     */
    @Override
    public UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    /**
     * Throws a UserCreationFailed error.
     * @param error a String describing the error that occurred
     */
    public UserRegisterResponseModel prepareFailView(String error){
        throw new UserCreationFailed(error);
    }
}
