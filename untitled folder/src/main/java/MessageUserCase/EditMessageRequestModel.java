package MessageUserCase;


public class EditMessageRequestModel {

    private String content;
    private User sender;
    private User receiver;


    public EditMessageRequestModel(String content, User sender, User receiver) {
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
    }

    String getContent(){
        return content
    }


}