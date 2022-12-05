package user_register.application_business_rules;

public interface UserRegisterInputBoundary {
    /**
     * Try creating a User object.
     * @param requestModel the information required to attempt create the User.
     * @return the result of trying to create the User.
     */
    UserRegisterResponseModel create(UserRegisterRequestModel requestModel);
}
