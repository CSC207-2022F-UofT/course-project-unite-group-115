package reaction_use_case;

import java.time.LocalDateTime;

public class ReactionCreateDsRequestModel {
    private final String reaction;

    private final int messageID;
    public ReactionCreateDsRequestModel(String reaction, int messageID){
        this.reaction = reaction;
        this.messageID = messageID;
    }

    public String getReaction(){ return this.reaction; }

    public int getMessageID(){ return this.messageID; }
}
