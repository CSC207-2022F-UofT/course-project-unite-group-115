package reaction_use_case;

public class ReactionDsRequestModel {
    private final String reaction;

    private final int messageID;
    public ReactionDsRequestModel(String reaction, int messageID){
        this.reaction = reaction;
        this.messageID = messageID;
    }

    public String getReaction(){ return this.reaction; }

    public int getMessageID(){ return this.messageID; }
}
