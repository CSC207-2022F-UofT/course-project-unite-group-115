package reaction_use_case;

import entities.Reaction;
import entities.ReactionFactory;

public class ReactionInteractor implements ReactionInputBoundary {

    final MessageDsGateway reactionDsGateway;

    final ReactionOutputBoundary reactionPresenter;

    final ReactionFactory reactionFactory;

    public ReactionInteractor(MessageDsGateway reactionDsGateway, ReactionOutputBoundary reactionPresenter,
                              ReactionFactory reactionFactory){
        this.reactionDsGateway = reactionDsGateway;
        this.reactionPresenter = reactionPresenter;
        this.reactionFactory = reactionFactory;
    }

    @Override
    public ReactionResponseModel createReaction(ReactionRequestModel requestModel){
        // Create new reaction to store in database
        Reaction reaction = reactionFactory.create(requestModel.getReaction(), requestModel.getMessageID());
        ReactionDsRequestModel reactionDsModel = new ReactionDsRequestModel(reaction.getReaction(),
                reaction.getMessageID());
        // Store reaction in database
        reactionDsGateway.addReaction(reactionDsModel);

        // Prepare for presenter
        ReactionResponseModel reactionResponseModel = new ReactionResponseModel(reaction.getReaction(),
                reaction.getMessageID());
        return reactionPresenter.prepareAdditionView(reactionResponseModel);
    }

    @Override
    public ReactionResponseModel removeReaction(ReactionRequestModel requestModel){
        // Create new entity and database request model
        Reaction reaction = reactionFactory.create(requestModel.getReaction(), requestModel.getMessageID());
        ReactionDsRequestModel reactionDsModel = new ReactionDsRequestModel(reaction.getReaction(),
                reaction.getMessageID());
        // Reaction already exists and needs to be removed
        reactionDsGateway.removeReaction(reactionDsModel);

        // Prepare for presenter
        ReactionResponseModel reactionResponseModel = new ReactionResponseModel(reaction.getReaction(),
                reaction.getMessageID());
        return reactionPresenter.prepareRemoveView(reactionResponseModel);
    }

}
