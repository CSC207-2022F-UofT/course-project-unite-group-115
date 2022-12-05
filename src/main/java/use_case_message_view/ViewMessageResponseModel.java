package use_case_message_view;

import java.util.List;

public class ViewMessageResponseModel {
    String presented;


    public ViewMessageResponseModel(String presented) {

        this.presented = presented;
    }


    public String getPresented(){return presented;}

    public void setPresented(String send){this.presented = presented;}

}
