package get_groups.application_business_rules;

public class GetGroupsRequestModel {
    String username;

    /**
     * Creates a data structure that contains the information required to get a user's groups.
     * @param username the user's name
     */
    public GetGroupsRequestModel(String username){
        this.username = username;
    }

    /**
     * Return the name of the user whose groups have been requested.
     */
    public String getUsername() {
        return username;
    }
}
