package use_cases.message_view.interface_adaptor;

public class ViewMessageFailure extends RuntimeException {
    public ViewMessageFailure(String errorMessage) {
        super(errorMessage);
    }
}
