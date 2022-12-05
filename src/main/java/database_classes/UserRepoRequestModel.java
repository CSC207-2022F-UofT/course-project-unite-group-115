package database_classes;
import java.time.LocalDateTime;

public class UserRepoRequestModel {
    private final String name;
    private String password;
    private final LocalDateTime creationTime;

    /**
     * Create a data structure containing all the information of the User.
     * @param name the username of the User
     * @param password the password of the User
     * @param creationTime the time the User account was created
     */
    public UserRepoRequestModel(String name, String password, LocalDateTime creationTime) {
        this.name = name;
        this.password = password;
        this.creationTime = creationTime;
    }

    /**
     * Returns the username of the User whose information is stored in the UserRepoRequestModel.
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the password of the User whose information is stored in the UserRepoRequestModel.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the User whose information is stored in the UserRepoRequestModel.
     * @param password the new password to be set for the User's acoount.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Returns the creation time  of the User whose information is stored in the UserRepoRequestModel.
     */
    public LocalDateTime getCreationTime() {
        return creationTime;
    }
}
