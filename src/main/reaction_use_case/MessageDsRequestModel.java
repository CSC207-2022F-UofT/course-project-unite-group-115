package reaction_use_case;
import java.time.LocalDateTime;

public class MessageDsRequestModel {
    private final Integer groupID;

    private LocalDateTime timestamp;

    private final String message;

    private final String sender;

    private String reaction;

    private Integer messageID;

    public MessageDsRequestModel(Integer groupID, LocalDateTime timestamp, String message, String sender,
                                 String reaction, Integer messageID){
        this.groupID = groupID;
        this.timestamp = timestamp;
        this.message = message;
        this.sender = sender;
        this.reaction = reaction;
        this.messageID = messageID;
    }

    public Integer getGroupID(){
        return this.groupID;
    }

    public LocalDateTime getTimestamp(){
        return this.timestamp;
    }

    public String getMessage(){
        return this.message;
    }

    public String getSender(){
        return this.sender;
    }

    public String getReaction(){
        return this.reaction;
    }

    public Integer getMessageID(){
        return this.messageID;
    }
}
