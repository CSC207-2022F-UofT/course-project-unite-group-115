package message_sebd.interface_adaptor;

public class MessageCreationFailed extends RuntimeException {
    public MessageCreationFailed(String error) {
        super(error);
    }

}
