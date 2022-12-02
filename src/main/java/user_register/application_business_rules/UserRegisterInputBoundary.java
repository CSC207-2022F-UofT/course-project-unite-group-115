package user_register.application_business_rules;

public interface UserRegisterInputBoundary {
    // Adding javadocs for UserRegister Feature
    UserRegisterResponseModel create(UserRegisterRequestModel requestModel);
}
