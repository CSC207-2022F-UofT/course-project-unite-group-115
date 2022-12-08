package use_cases.message_send.interface_adaptor;

public class MessageCreationFailed extends RuntimeException {
    public MessageCreationFailed(String error) {
        super(error);
    }

}
