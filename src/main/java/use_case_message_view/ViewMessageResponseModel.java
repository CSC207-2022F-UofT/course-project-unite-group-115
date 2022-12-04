package use_case_message_view;

import java.util.List;

public class ViewMessageResponseModel {
    List<String> presented;


    public ViewMessageResponseModel(List<String> presented) {

        this.presented = presented;
    }


    public List<String> getPresented(){return presented;}

    public void setPresented(String send){this.presented = presented;}

}
