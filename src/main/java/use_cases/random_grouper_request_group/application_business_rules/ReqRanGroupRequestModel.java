package use_cases.random_grouper_request_group.application_business_rules;

public class ReqRanGroupRequestModel {
    private String userName;

    /**
     * Creates a data structure that contains the information required for a User to be added to a random group.
     * @param userName the User's name
     */
    public ReqRanGroupRequestModel(String userName) {
        this.userName = userName;
    }

    /**
     * Returns the username of the user who requested to be added to a random group.
     */
    public String getUserName() {
        return userName;
    }
}
