package Databases;

import java.time.LocalDateTime;


public class MessageDsRequestModel {

    private String content;
    private final String sender;
    private final String receiver;

    private final String ID;
    private final LocalDateTime creationTime;


    public MessageDsRequestModel(String content, String sender, String receiver, String id, LocalDateTime creationTime) {
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.ID = id;
        this.creationTime = creationTime;
    }


    public String getContent() {
        return content;
    }
    public void setContent() {
        this.content = content;
    }

    public String getSender(){
        return sender;
    }

    public String getReceiver(){
        return receiver;
    }

    public String getID(){return ID;}
    public LocalDateTime getCreationTime() {
        return creationTime;
    }


}
