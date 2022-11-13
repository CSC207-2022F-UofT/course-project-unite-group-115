package user_register.application_business_rules;

public interface UserRegisterInputBoundary {
    UserRegisterResponseModel create(UserRegisterRequestModel requestModel);
}
