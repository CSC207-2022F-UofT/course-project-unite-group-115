package interface_adapters;

/**
 * ReactionActionFailed is an error type which holds a string specifying
 * why the reaction action failed.
 *
 * @author  Hansel Jia
 */
public class ReactionActionFailed extends RuntimeException{
    public ReactionActionFailed(String error) {
        super(error);
    }
}
