package reaction_use_case.application_business_rules;

/**
 * ReactionRequestModel is a data structure passed from the controller to the interactor.
 * It contains information about the reaction and the message it is to be added/removed from.
 *
 * @author  Hansel Jia
 */
public class ReactionRequestModel {
    private final String reaction;
    private final String messageID;

    public ReactionRequestModel(String reaction, String messageID){
        this.reaction = reaction;
        this.messageID = messageID;
    }

    /**
     * This method is used to get the reaction from the request model.
     * @return String The string contains the reaction type (heart, smile, cry)
     */
    public String getReaction(){
        return this.reaction;
    }

    /**
     * This method is used to get the messageID from the request model.
     * @return String The string contains the messageID associated with the reaction.
     */
    public String getMessageID(){
        return this.messageID;
    }
}
