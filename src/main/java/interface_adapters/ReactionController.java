package interface_adapters;

import reaction_use_case.ReactionInputBoundary;
import reaction_use_case.ReactionRequestModel;
import reaction_use_case.ReactionResponseModel;

public class ReactionController {
    final ReactionInputBoundary reactionInput;

    public ReactionController(ReactionInputBoundary reactionInput){ this.reactionInput = reactionInput; }

    ReactionResponseModel create(String reaction, String messageID) {
        ReactionRequestModel requestModel = new ReactionRequestModel(reaction, messageID);

        return reactionInput.createReaction(requestModel);
    }
}
