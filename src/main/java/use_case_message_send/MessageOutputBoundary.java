package use_case_message_send;

public interface MessageOutputBoundary {
    MessageResponseModel prepareSuccessView(MessageResponseModel response);

    MessageResponseModel prepareFailView(String error);
}