package use_cases.reaction_use_case.application_business_rules;

import database_classes.MessageRepoInt;

/**
 * The ReactionInteractor implements interface ReactionInputBoundary that
 * contains the methods to add and remove reactions to the database.
 * This class takes in the ReactionRequestModel data structure and sends a
 * ReactionResponseModel to the presenter.
 *
 * @author  Hansel Jia
 */

public class ReactionInteractor implements ReactionInputBoundary {

    final MessageRepoInt messageRepoInt;

    final ReactionOutputBoundary reactionOutputBoundary;

    public ReactionInteractor(MessageRepoInt messageRepoInt, ReactionOutputBoundary reactionPresenter){
        this.messageRepoInt = messageRepoInt;
        this.reactionOutputBoundary = reactionPresenter;
    }

    /**
     * This method is used to add a reaction to the database.
     * If the messageID does not exist in the database or the reaction has already been added previously,
     * the reaction will not be added and an error string will be given.
     * If none of the above, the reaction will be added to the corresponding message
     * in the database.
     * @param requestModel This parameter contains the ReactionRequestModel data structure
     *                     which holds information on the reaction type and the message
     *                     the reaction is to be added to.
     * @return ReactionResponseModel The interactor will pass a ReactionResponseModel DS
     * to the presenter to then display to the UI
     */
    @Override
    public ReactionResponseModel addReaction(ReactionRequestModel requestModel){
//        Check if either the messageID does not correspond to a message
//        or the reaction already exists on the message
        if (messageRepoInt.messageNotExist(requestModel.getMessageID())){
            return reactionOutputBoundary.prepareFailView("Message with ID: " +
                    requestModel.getMessageID() + " does not exist.");
        } else if (messageRepoInt.reactionExists(requestModel.getReaction(), requestModel.getMessageID())){
            return reactionOutputBoundary.prepareFailView("Reaction already exists on message: " +
                    requestModel.getMessageID());
        }

        // Add the reaction to the database
        messageRepoInt.addReaction(requestModel.getReaction(), requestModel.getMessageID());
        // Prepare for presenter
        ReactionResponseModel reactionResponseModel = new ReactionResponseModel(requestModel.getReaction(),
                requestModel.getMessageID());
        return reactionOutputBoundary.prepareSuccessView(reactionResponseModel);
    }

    /**
     * This method is used to remove a reaction from the database.
     * If the messageID or the reaction corresponding to the message does not exist in the database,
     * the reaction will not be removed and an error string will be given.
     * If none of the above, the reaction will be removed from the corresponding message
     * in the database.
     * @param requestModel This parameter contains the ReactionRequestModel data structure
     *                     which holds information on the reaction type and the message
     *                     the reaction is to be added to.
     * @return ReactionResponseModel The interactor will pass a ReactionResponseModel DS
     * to the presenter to then display to the UI
     */
    @Override
    public ReactionResponseModel removeReaction(ReactionRequestModel requestModel){
        if (messageRepoInt.messageNotExist(requestModel.getMessageID())) {
            return reactionOutputBoundary.prepareFailView("Message with ID: " +
                    requestModel.getMessageID() + " does not exist.");
        } else if (!messageRepoInt.reactionExists(requestModel.getReaction(), requestModel.getMessageID())) {
            return reactionOutputBoundary.prepareFailView("Reaction does not exists on message: " +
                    requestModel.getMessageID());
        }

        // Remove the reaction from the database
        messageRepoInt.removeReaction(requestModel.getReaction(), requestModel.getMessageID());
        // Prepare for presenter
        ReactionResponseModel reactionResponseModel = new ReactionResponseModel(requestModel.getReaction(),
                requestModel.getMessageID());
        return reactionOutputBoundary.prepareSuccessView(reactionResponseModel);
    }

}
