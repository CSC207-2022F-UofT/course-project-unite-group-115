package interface_adapters_message;

public class MessageCreationFailed extends RuntimeException {
    public MessageCreationFailed(String error) {
        super(error);
    }

}
