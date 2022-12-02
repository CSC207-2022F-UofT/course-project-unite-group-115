package user_register.application_business_rules;

public interface UserRegisterOutputBoundary {
    UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel user);

    UserRegisterResponseModel prepareFailView(String error);
}
