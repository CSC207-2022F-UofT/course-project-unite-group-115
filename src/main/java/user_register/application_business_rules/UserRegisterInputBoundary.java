package user_register.application_business_rules;

public interface UserRegisterInputBoundary {
    // Adding javadocs
    UserRegisterResponseModel create(UserRegisterRequestModel requestModel);
}
