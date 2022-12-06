package get_user_sensitiveWordList.application_business_rules;


import java.util.List;

public class GetUserListResponseModel {
    private List<String> SensList;
    private String failMessage;



    public GetUserListResponseModel(List<String> list){
        this.SensList = list;


    }
    public GetUserListResponseModel(String errorMessage) {
        this.failMessage = errorMessage;
    }

    /**
     * Return the user's SensitiveWordList.
     */
    public List<String> getSensList() {
        return SensList;
    }
    public void setSensList(List<String> list) {
        this.SensList = list;
    }

    public String getFailMessage() {
        return failMessage;
    }
}
