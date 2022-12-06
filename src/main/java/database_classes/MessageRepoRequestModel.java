package database_classes;

import java.time.LocalDateTime;
import java.util.List;


public class MessageRepoRequestModel {

    private String content;
    private final String sender;
    private final String groupID;

    private final String messageID;
    private List<String> reaction;
    private final LocalDateTime creationTime;


    public MessageRepoRequestModel(String content, String sender, String groupID, String messageID, List<String> reaction, LocalDateTime creationTime) {
        this.content = content;
        this.sender = sender;
        this.groupID = groupID;
        this.messageID = messageID;
        this.reaction = reaction;;
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

    public List<String> getReaction(){return reaction;}

}
