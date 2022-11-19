package MessageUserCase;

public class MessageResponseModel {

    String newcontent;
    String editTime;

    public MessageResponseModel(String newcontent, String editTime) {
        this.newcontent = newcontent;
        this.editTime = editTime;
    }




    public void setContent(String content) {
        this.newcontent = content;
    }

    public String getTime() {
        return editTime;
    }


}