package add_blocked_users.application_business_rules;

public class AddBlockedUserRequestModel {
    String username;
    String blockedName;

    /**
     * Creates a data structure that contains the information required to get a user's SensitiveList.
     * @param username the user's name
     */
    public AddBlockedUserRequestModel(String username,String blockedName){
        this.username = username;
        this.blockedName =blockedName;
    }

    /**
     * Return the name of the user whose interests have been requested.
     */
    public String getUsername() {
        return username;
    }
    public String getBlockedName() {
        return blockedName;
    }
}