package reaction_use_case;

import databases.MessageRepoInt;
import entities.ReactionFactory;

public class ReactionInteractor implements ReactionInputBoundary {

    final MessageRepoInt messageRepoInt;

    final ReactionOutputBoundary reactionOutputBoundary;

    final ReactionFactory reactionFactory;

    public ReactionInteractor(MessageRepoInt messageRepoInt, ReactionOutputBoundary reactionPresenter,
                              ReactionFactory reactionFactory){
        this.messageRepoInt = messageRepoInt;
        this.reactionOutputBoundary = reactionPresenter;
        this.reactionFactory = reactionFactory;
    }

    @Override
    public ReactionResponseModel createReaction(ReactionRequestModel requestModel){
        /* Check if either the messageID does not correspond to a message
         * or the reaction already exists on the message
         */
        if (messageRepoInt.messageNotExist(requestModel.getMessageID())){
            return reactionOutputBoundary.prepareFailView("Message with ID: " +
                    requestModel.getMessageID() + " does not exist.");
        } else if (messageRepoInt.reactionExists(requestModel.getReaction(), requestModel.getMessageID())){
            return reactionOutputBoundary.prepareFailView("Reaction already exists on message: " +
                    requestModel.getMessageID());
        }

        messageRepoInt.addReaction(requestModel.getReaction(), requestModel.getMessageID());
        // Prepare for presenter
        ReactionResponseModel reactionResponseModel = new ReactionResponseModel(requestModel.getReaction(),
                requestModel.getMessageID());
        return reactionOutputBoundary.prepareSuccessView(reactionResponseModel);
    }

    @Override
    public ReactionResponseModel removeReaction(ReactionRequestModel requestModel){
        if (messageRepoInt.messageNotExist(requestModel.getMessageID())) {
            return reactionOutputBoundary.prepareFailView("Message with ID: " +
                    requestModel.getMessageID() + " does not exist.");
        } else if (!messageRepoInt.reactionExists(requestModel.getReaction(), requestModel.getMessageID())) {
            return reactionOutputBoundary.prepareFailView("Reaction does not exists on message: " +
                    requestModel.getMessageID());
        }

        messageRepoInt.removeReaction(requestModel.getReaction(), requestModel.getMessageID());
        // Prepare for presenter
        ReactionResponseModel reactionResponseModel = new ReactionResponseModel(requestModel.getReaction(),
                requestModel.getMessageID());
        return reactionOutputBoundary.prepareSuccessView(reactionResponseModel);
    }

}
