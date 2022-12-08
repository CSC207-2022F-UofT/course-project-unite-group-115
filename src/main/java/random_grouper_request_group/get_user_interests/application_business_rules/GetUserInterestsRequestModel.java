package random_grouper_request_group.get_user_interests.application_business_rules;

public class GetUserInterestsRequestModel {
    String username;

    /**
     * Creates a data structure that contains the information required to get a user's interests.
     * @param username the user's name
     */
    public GetUserInterestsRequestModel(String username){
        this.username = username;
    }

    /**
     * Return the name of the user whose interests have been requested.
     */
    public String getUsername() {
        return username;
    }
}
