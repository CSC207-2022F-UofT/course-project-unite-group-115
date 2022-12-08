package use_cases.reaction_use_case.application_business_rules;

/**
 * ReactionResponseModel is a data structure passed from the interactor to the presenter.
 * It contains information about the reaction and the message it is associated with.
 *
 * @author  Hansel Jia
 */
public class ReactionResponseModel {
    private final String reaction;

    private final String messageID;

    public ReactionResponseModel(String reaction, String messageID){
        this.reaction = reaction;
        this.messageID = messageID;
    }

    /**
     * This method is used to get the reaction from the request model.
     * @return String The string contains the reaction type (heart, smile, cry)
     */
    public String getReaction() {
        return reaction;
    }

    /**
     * This method is used to get the messageID from the request model.
     * @return String The string contains the messageID associated with the reaction.
     */
    public String getMessageID(){
        return messageID;
    }
}
