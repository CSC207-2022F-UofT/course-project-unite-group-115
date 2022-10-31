package MessageUserCase;

public class EditMessageResponseModel {

    String content;
    String editTime;

    public UserRegisterResponseModel(String login, String editTime) {
        this.editTime = editTime;
    }



    public String getCreationTime() {
        return creationTime;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEditTime() {
        return editTime;
    }


}