package reaction_use_case;

public class ReactionResponseModel {
    private String reaction;

    private final String messageID;

    public ReactionResponseModel(String reaction, String messageID){
        this.reaction = reaction;
        this.messageID = messageID;
    }

    public String getReaction() {
        return reaction;
    }

    public void removeReaction() { this.reaction = null; }

    public String getMessageID(){
        return messageID;
    }
}
