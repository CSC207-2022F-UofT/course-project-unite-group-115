package user_register.application_business_rules;

public interface UserRegisterOutputBoundary {
    /**
     * Format the successful result of creating a User.
     * @param user the response model created by the interactor
     * @return the formatted response model
     */
    UserRegisterResponseModel prepareSuccessView(UserRegisterResponseModel user);

    /**
     * Throws an error that contains an <errorMessage> that describes the error that occurred.
     * @param error a String describing the error that occurred.
     */
    UserRegisterResponseModel prepareFailView(String error);
}
