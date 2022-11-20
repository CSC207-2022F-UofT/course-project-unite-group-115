package MessageUserCase;


public class MessageRequestModel {

    private String content;
    private String sender;
    private String receiver;


    public MessageRequestModel(String content, String sender, String receiver) {
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
    }

    String getContent(){
        return content;
    }

    void setContent(String content) {this.content = content;}

    String getSender(){return sender;}

    void setSender(String sender){this.sender = sender;}

    String getReceiver(){return receiver;}

    void setReceiver(String receiver){this.receiver = receiver;}



}