package MessageUserCase;

public class EditMessageResponseModel {

    String newcontent;
    String editTime;

    public MessageResponseModel(String newcontent, String editTime) {
        this.newcontent = newcontent
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