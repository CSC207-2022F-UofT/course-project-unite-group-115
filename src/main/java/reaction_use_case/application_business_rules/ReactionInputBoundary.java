package reaction_use_case.application_business_rules;

/**
 * The ReactionInputBoundary is an interface implemented by the interactor.
 *
 * @author  Hansel Jia
 */
public interface ReactionInputBoundary {

    /**
     * This method is used to add a reaction to the database.
     * @param requestModel This parameter contains the ReactionRequestModel data structure
     *                     which holds information on the reaction type and the message
     *                     the reaction is to be added to.
     * @return ReactionResponseModel The interactor will pass a ReactionResponseModel DS
     * to the presenter to then display to the UI
     */
    ReactionResponseModel addReaction(ReactionRequestModel requestModel);

    /**
     * This method is used to remove a reaction from the database.
     * @param requestModel This parameter contains the ReactionRequestModel data structure
     *                     which holds information on the reaction type and the message
     *                     the reaction is to be added to.
     * @return ReactionResponseModel The interactor will pass a ReactionResponseModel DS
     * to the presenter to then display to the UI
     */
    ReactionResponseModel removeReaction(ReactionRequestModel requestModel);
}
