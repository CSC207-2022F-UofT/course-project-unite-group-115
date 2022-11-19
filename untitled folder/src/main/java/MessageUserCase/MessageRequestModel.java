package MessageUserCase;


public class MessageRequestModel {

    private String content;
    private User sender;
    private User receiver;


    public MessageRequestModel(String content, User sender, User receiver) {
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
    }

    String getContent(){
        return content;
    }


}