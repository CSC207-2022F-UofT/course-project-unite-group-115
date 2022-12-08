package use_cases.message_view.application_business_rule;

public class ViewMessageResponseModel {
    String presented;


    public ViewMessageResponseModel(String presented) {

        this.presented = presented;
    }


    public String getPresented(){return presented;}

    public void setPresented(String send){this.presented = presented;}

}
