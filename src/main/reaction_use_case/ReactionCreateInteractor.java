package reaction_use_case;

import entities.Reaction;
import entities.ReactionFactory;
import Databases.MessageDsGateway;

public class ReactionCreateInteractor implements ReactionCreateInputBoundary{

    final MessageDsGateway reactionDsGateway;

    final ReactionCreatePresenter reactionPresenter;

    final ReactionFactory reactionFactory;

    public ReactionCreateInteractor(MessageDsGateway reactionDsGateway, ReactionCreatePresenter reactionPresenter,
                                    ReactionFactory reactionFactory){
        this.reactionDsGateway = reactionDsGateway;
        this.reactionPresenter = reactionPresenter;
        this.reactionFactory = reactionFactory;
    }

    @Override
    public ReactionCreateResponseModel create(ReactionCreateRequestModel requestModel){
//        if(reactionDsGateway.reactionExists(requestModel.getMessageID())){
//            // Reaction already exists and needs to be removed
//            reactionDsGateway.removeReaction(requestModel.getMessageID());
//            ReactionCreateResponseModel reactionResponseModel = new ReactionCreateResponseModel("",
//            requestMode.getMessageID();
//            return reactionPresenter.prepareRemoveView(reactionResponseModel)
//        } else {
            // Create new reaction to store in database
        Reaction reaction = reactionFactory.create(requestModel.getReaction(), requestModel.getMessageID());
        ReactionCreateDsRequestModel reactionDsModel = new ReactionCreateDsRequestModel(reaction.getReaction(),
                reaction.getMessageID());
        // Store reaction in database
        reactionDsGateway.addReaction(reactionDsModel);

        ReactionCreateResponseModel reactionResponseModel = new ReactionCreateResponseModel(reaction.getReaction(),
                reaction.getMessageID());
        return reactionPresenter.prepareAdditionView(reactionResponseModel);
        //}
    }
}
