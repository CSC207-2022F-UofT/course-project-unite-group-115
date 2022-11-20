package MessageUserCase;

public interface MessageOutputBoundary {
    MessageResponseModel prepareSuccessView(MessageResponseModel response);

    MessageResponseModel prepareFailView(String error);
}