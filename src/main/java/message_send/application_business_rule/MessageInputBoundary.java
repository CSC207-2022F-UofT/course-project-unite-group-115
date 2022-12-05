package message_send.application_business_rule;

public interface MessageInputBoundary {
    MessageResponseModel create(MessageRequestModel requestModel);
}



