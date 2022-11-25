package Entity;

import java.util.UUID;



public class Message{
    private String content;       //what if pictures are send, how to store it?
    private final String sender;        //Grouper?
    private String groupID;


    private final UUID messageID;

    public Message(String content, String sender, String groupID){
        this.content = content;
        this.sender = sender;
        this.groupID = groupID;
        this.messageID = UUID.randomUUID();
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


}

