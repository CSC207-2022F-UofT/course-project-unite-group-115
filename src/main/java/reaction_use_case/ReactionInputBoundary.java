package reaction_use_case;

public interface ReactionInputBoundary {
    ReactionResponseModel createReaction(ReactionRequestModel requestModel);

    ReactionResponseModel removeReaction(ReactionRequestModel requestModel);
}
