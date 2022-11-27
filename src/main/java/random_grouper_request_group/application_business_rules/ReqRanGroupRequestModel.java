package random_grouper_request_group.application_business_rules;

public class ReqRanGroupRequestModel {
    private String userName;


    public ReqRanGroupRequestModel(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    // ToDo: Remove if not used
    public void setUserName(String userName) {
        this.userName = userName;
    }
}
