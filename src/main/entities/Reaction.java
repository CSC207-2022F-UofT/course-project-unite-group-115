package entities;

public class Reaction {

    private final String reaction;
    private final String messageID;

    Reaction(String reaction, String messageID){
        this.reaction = reaction;
        this.messageID = messageID;
    }

    public String getReaction() {
        return this.reaction;
    }

    public String getMessageID() {
        return this.messageID;
    }
}
