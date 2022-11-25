package interface_adapters;

public class MessageCreationFailed extends RuntimeException {
    public MessageCreationFailed(String error) {
        super(error);
    }

}
