package reaction_use_case;

import entities.Reaction;

public interface ReactionCreatePresenter {
    ReactionCreateResponseModel prepareAdditionView(ReactionCreateResponseModel Reaction);

    ReactionCreateResponseModel prepareRemoveView(ReactionCreateResponseModel Reaction);

}
