package use_cases.message_send.application_business_rule;

public interface MessageInputBoundary {
    MessageResponseModel create(MessageRequestModel requestModel);
}



