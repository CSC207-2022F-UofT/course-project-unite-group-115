package reaction_use_case;

public class ReactionResponseModel {
    private String reaction;

    private int messageID;

    public ReactionResponseModel(String reaction, int messageID){
        this.reaction = reaction;
        this.messageID = messageID;
    }

    public String getReaction() {
        return reaction;
    }

    public void removeReaction() { this.reaction = null; }

    public int getMessageID(){
        return messageID;
    }
}
