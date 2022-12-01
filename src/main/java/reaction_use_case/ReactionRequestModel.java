package reaction_use_case;

public class ReactionRequestModel {
    private final String reaction;
    private final String messageID;

    public ReactionRequestModel(String reaction, String messageID){
        this.reaction = reaction;
        this.messageID = messageID;
    }

    public String getReaction(){
        return this.reaction;
    }

    public String getMessageID(){
        return this.messageID;
    }
}
