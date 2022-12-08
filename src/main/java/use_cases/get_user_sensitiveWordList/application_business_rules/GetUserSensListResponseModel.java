package use_cases.get_user_sensitiveWordList.application_business_rules;


import java.util.List;

public class GetUserSensListResponseModel {
    private List<String> SensList;
    private String failMessage;



    public GetUserSensListResponseModel(List<String> list){
        this.SensList = list;


    }
    public GetUserSensListResponseModel(String errorMessage) {
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
