package entity_message;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;



public class Message{
    private String content;       //what if pictures are send, how to store it?
    private final String sender;        //Grouper?
    private String groupID;

    private List<String> reaction;


    private final UUID messageID;

    public Message(String content, String sender, String groupID){
        this.content = content;
        this.sender = sender;
        this.groupID = groupID;
        this.messageID = UUID.randomUUID();
        this.reaction = new ArrayList<>();
    }

    public boolean contentIsValid() {
        return content != null && content.length() > 1;
    }

    public String getContent(){
        return this.content;
    }
    public String getSender(){return this.sender;}
    public String getGroupID(){return this.groupID;}

    public void setContent(String content){
         this.content = content;
    }

    public UUID getID(){
        return messageID;
    }

    public List<String> getReaction() {return reaction;}

    public void setReaction(String rea){reaction.add(rea);}


}

