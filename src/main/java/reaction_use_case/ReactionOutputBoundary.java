package reaction_use_case;

public interface ReactionOutputBoundary {
    ReactionResponseModel prepareSuccessView(ReactionResponseModel Reaction);

    ReactionResponseModel prepareFailView(String error);

}
