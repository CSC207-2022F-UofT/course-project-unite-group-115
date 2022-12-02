package messgae_use_case;

import java.util.List;

public class ViewMessageResponseModel {
    List<String> presented;


    public ViewMessageResponseModel(List<String> presented) {

        this.presented = presented;
    }


    public List<String> getSend(){return presented;}

    public void setSend(String send){this.presented = presented;}

}
