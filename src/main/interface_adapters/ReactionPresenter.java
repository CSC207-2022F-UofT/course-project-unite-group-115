package interface_adapters;

import entities.Reaction;
import reaction_use_case.ReactionOutputBoundary;
import reaction_use_case.ReactionResponseModel;

public class ReactionPresenter implements ReactionOutputBoundary {
    @Override
    public ReactionResponseModel prepareAdditionView(ReactionResponseModel response){
        return response;
    }

    @Override
    public ReactionResponseModel prepareRemoveView(ReactionResponseModel response){
        response.removeReaction();
        return response;
    }

}
