package use_cases.message_send.application_business_rule;

public interface MessageOutputBoundary {
    MessageResponseModel prepareSuccessView(MessageResponseModel response);

    MessageResponseModel prepareFailView(String error);
}