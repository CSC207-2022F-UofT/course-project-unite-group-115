package reaction_use_case;

public class ReactionCreateRequestModel {
    private String reaction;
    private int messageID;

    public ReactionCreateRequestModel(String reaction, int messageID){
        this.reaction = reaction;
        this.messageID = messageID;
    }

    public String getReaction(){
        return this.reaction;
    }

    public int getMessageID(){
        return this.messageID;
    }
}
