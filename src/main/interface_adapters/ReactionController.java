package interface_adapters;

import reaction_use_case.ReactionInputBoundary;

public class ReactionController {
    final ReactionInputBoundary reactionInput;

    public ReactionController(ReactionInputBoundary reactionInput){ this.reactionInput = reactionInput; }
}
