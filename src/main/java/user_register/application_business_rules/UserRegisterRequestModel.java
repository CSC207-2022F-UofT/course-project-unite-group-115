package user_register.application_business_rules;

public class UserRegisterRequestModel {

    private String name;
    private String password;
    private String repeatPassword;

    /**
     * Creates a data structure that contains the information required to create a new user.
     * @param name the name of the new User.
     * @param password the password for that User's account.
     * @param repeatPassword the re-entered password for confirmation.
     */
    public UserRegisterRequestModel(String name, String password, String repeatPassword) {
        this.name = name;
        this.password = password;
        this.repeatPassword = repeatPassword;
    }

    /**
     * Returns the username of the User that is going to be created.
     */
    String getName() {
        return name;
    }

    /**
     * Sets the username of the User that is going to be created.
     * @param name the new password to be set for the User's account.
     */
    void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the password of the User that is going to be created.
     */
    String getPassword() {
        return password;
    }

    /**
     * Sets the password of the User that is going to be created.
     * @param password the new password to be set for the User's account.
     */
    void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the re-entered password of the user that is going to be created.
     */
    public String getRepeatPassword() {
        return repeatPassword;
    }

    /**
     * Sets the repeat password of the User that is going to be created.
     * @param repeatPassword the new password to be set for the User's account.
     */
    public void setRepeatPassword(String repeatPassword) {
        this.repeatPassword = repeatPassword;
    }
}
