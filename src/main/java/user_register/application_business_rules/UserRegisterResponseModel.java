package user_register.application_business_rules;

public class UserRegisterResponseModel {

    String login;
    String creationTime;

    /**
     * Creates a data structure that contains information about a successful group creation
     * @param login username of the created User
     * @param creationTime time the User was created
     */
    public UserRegisterResponseModel(String login, String creationTime) {
        this.login = login;
        this.creationTime = creationTime;
    }

    /**
     * Returns the username of the User that is going to be created.
     */
    public String getLogin() {
        return login;
    }
    /**
     * Sets the username of the User that is going to be created.
     * @param login the new password to be set for the User's account.
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Returns the time that the new group was reportedly created.
     */
    public String getCreationTime() {
        return creationTime;
    }

    /**
     * Changes the time that the new group was reportedly created.
     */
    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

}
