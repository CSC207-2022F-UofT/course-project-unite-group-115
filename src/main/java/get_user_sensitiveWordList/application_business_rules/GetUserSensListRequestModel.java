package get_user_sensitiveWordList.application_business_rules;

public class GetUserSensListRequestModel {
    String username;

    /**
     * Creates a data structure that contains the information required to get a user's SensitiveList.
     * @param username the user's name
     */
    public GetUserSensListRequestModel(String username){
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
}
