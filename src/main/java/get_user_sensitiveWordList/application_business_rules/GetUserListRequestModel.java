package get_user_sensitiveWordList.application_business_rules;

public class GetUserListRequestModel {
    String username;

    /**
     * Creates a data structure that contains the information required to get a user's SensitiveList.
     * @param username the user's name
     */
    public GetUserListRequestModel(String username){
        this.username = username;
    }

    /**
     * Return the name of the user whose interests have been requested.
     */
    public String getUsername() {
        return username;
    }
}
