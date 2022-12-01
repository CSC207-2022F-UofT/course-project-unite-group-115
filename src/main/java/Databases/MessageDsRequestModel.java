package Databases;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MessageDsRequestModel {
    private String content;
    private final String sender;
    private final String groupID;

    private final String messageID;
    private final List<String> reaction;
    private final LocalDateTime creationTime;


    public MessageDsRequestModel(String content, String sender, String groupID, String messageID, List<String> reaction, LocalDateTime creationTime) {
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

    public String getReaction(){
        String reactionString = this.reaction.toString();
        reactionString = reactionString.replace(",", "");
        return reactionString;
    }
    public void addReaction(String reaction){
        String reactionString = this.reaction.toString();
        reactionString = reactionString.replace(",", "");
        System.out.println(reactionString);
        this.reaction.add(reaction);
    }

    public void removeReaction(String reaction){
        for (int i = 0; i < this.reaction.size();i++) {
            if (Objects.equals(this.reaction.get(i), reaction)){
                String temp = this.reaction.remove(i);
                return;
            }
        }
    }

    public boolean checkReactionExists(String reaction){
        for (String s : this.reaction) {
            if (Objects.equals(s, reaction)) {
                return true;
            }
        }
        return false;
    }
}
