package message_sebd.application_business_rule;

public interface MessageOutputBoundary {
    MessageResponseModel prepareSuccessView(MessageResponseModel response);

    MessageResponseModel prepareFailView(String error);
}