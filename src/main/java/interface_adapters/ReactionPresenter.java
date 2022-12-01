package interface_adapters;

import reaction_use_case.ReactionOutputBoundary;
import reaction_use_case.ReactionResponseModel;

public class ReactionPresenter implements ReactionOutputBoundary {
    @Override
    public ReactionResponseModel prepareSuccessView(ReactionResponseModel response){
        return response;
    }

    @Override
    public ReactionResponseModel prepareFailView(String error){
        throw new ReactionActionFailed(error);
    }

}
