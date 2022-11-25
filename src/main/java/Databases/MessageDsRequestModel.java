package Databases;

import java.time.LocalDateTime;


public class MessageDsRequestModel {

    private String content;
    private final String sender;
    private final String groupID;

    private final String messageID;
    private final LocalDateTime creationTime;


    public MessageDsRequestModel(String content, String sender, String groupID, String messageID, LocalDateTime creationTime) {
        this.content = content;
        this.sender = sender;
        this.groupID = groupID;
        this.messageID = messageID;
        this.creationTime = creationTime;
    }


    public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    public String getSender(){
        return sender;
    }

    public String getGroupID(){
        return groupID;
    }

    public String getMessageID(){return messageID;}
    public LocalDateTime getCreationTime() {
        return creationTime;
    }


}
