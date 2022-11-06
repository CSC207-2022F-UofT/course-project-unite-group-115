package entities;

public class Reaction {

    private final String reaction;
    private final Integer messageID;

    Reaction(String reaction, Integer messageID){
        this.reaction = reaction;
        this.messageID = messageID;
    }

    public String getReaction() {
        return this.reaction;
    }

    public Integer getMessageID() {
        return this.messageID;
    }
}
