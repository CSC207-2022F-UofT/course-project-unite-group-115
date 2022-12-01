package interface_adapters;

public class ReactionActionFailed extends RuntimeException{
    public ReactionActionFailed(String error) {
        super(error);
    }
}
