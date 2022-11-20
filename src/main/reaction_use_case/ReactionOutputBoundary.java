package reaction_use_case;

public interface ReactionOutputBoundary {
    ReactionResponseModel prepareAdditionView(ReactionResponseModel Reaction);

    ReactionResponseModel prepareRemoveView(ReactionResponseModel Reaction);

}
