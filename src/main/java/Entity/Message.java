package Entity;

import java.time.LocalDateTime;
import java.util.UUID;



public class Message{
    private String content;       //what if pictures are send, how to store it?
    private final String sender;        //Grouper?
    private String receiver;


    private final UUID ID;

    public Message(String content, String sender, String receiver){
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.ID = UUID.randomUUID();
    }


    public String getContent(){
        return this.content;
    }
    public String getSender(){return this.sender;}
    public String getReceiver(){return this.receiver;}

    public void setContent(String content){
         this.content = content;
    }

    public UUID getID(){
        return ID;
    }


}

