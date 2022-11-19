package Entity;

import User;
import java.time.LocalDateTime;
import java.util.UUID;



public class Message{
    private String content;       //what if pictures are send, how to store it?
    private User sender;        //Grouper?
    private User receiver;
    // record and display time?
    // status of read/unread
    private LocalDateTime creationTime;
    private final UUID ID;

    public Message(String content, User sender, User receiver){
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.creationTime = creationTime;  //imcomplete
        this.ID = UUID.randomUUID();
    }


    public String getContent(){
        return this.content;
    }

    public String setContent(){
         this.content = content;
    }

    public UUID getID(){
        return ID;
    }

    public LocalDateTime getCreationTime() {
        return creationTime;
    }


}

