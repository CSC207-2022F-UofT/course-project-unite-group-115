package database_classes;

public interface UserRepoInt {
    /**
     * Check whether the inputted username exists in User Database already or not
     * @param identifier the inputted username
     */
    boolean existsByName(String identifier);

    /**
     * Save the inputted information in the User Database
     * @param requestModel the model of inputted data.
     */
    void save(UserRepoRequestModel requestModel);
}
