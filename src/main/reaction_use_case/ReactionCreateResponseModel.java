package reaction_use_case;

public class ReactionCreateResponseModel {
    private String reaction;

    private int messageID;

    public ReactionCreateResponseModel(String reaction, int messageID){
        this.reaction = reaction;
        this.messageID = messageID;
    }

    public String getReaction() {
        return reaction;
    }

    public int getMessageID(){
        return messageID;
    }
}
