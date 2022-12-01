package databases;

public class ReactionDsRequestModel {
    private final String reaction;

    private final String messageID;

    public ReactionDsRequestModel(String reaction, String messageID){
        this.reaction = reaction;
        this.messageID = messageID;
    }

    public String getReaction(){ return this.reaction; }

    public String getMessageID(){ return this.messageID; }
}
