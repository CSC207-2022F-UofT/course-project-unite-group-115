package use_cases.reaction_use_case.interface_adapters;

import use_cases.reaction_use_case.application_business_rules.ReactionInputBoundary;
import use_cases.reaction_use_case.application_business_rules.ReactionRequestModel;
import use_cases.reaction_use_case.application_business_rules.ReactionResponseModel;

/**
 * The ReactionController is called by the UI and is responsible for calling
 * the methods within the reaction interactor.
 *
 * @author  Hansel Jia
 */
public class ReactionController {
    final ReactionInputBoundary reactionInteractor;
    public ReactionController(ReactionInputBoundary reactionInput){ this.reactionInteractor = reactionInput; }

    /**
     * This method is used to create a request model data structure and pass it into the
     * interactor to add a message.
     * @param reaction This parameter contains the reaction to be added.
     * @param messageID This parameter contains the messageID associated with the reaction.
     */
    public ReactionResponseModel addReaction(String reaction, String messageID) {
        ReactionRequestModel requestModel = new ReactionRequestModel(reaction, messageID);

        return reactionInteractor.addReaction(requestModel);
    }

    /**
     * This method is used to create a request model data structure and pass it into the
     * interactor to remove a message.
     * @param reaction This parameter contains the reaction to be removed.
     * @param messageID This parameter contains the messageID associated with the reaction.
     */
    public ReactionResponseModel removeReaction(String reaction, String messageID) {
        ReactionRequestModel requestModel = new ReactionRequestModel(reaction, messageID);

        return reactionInteractor.removeReaction(requestModel);
    }
}
