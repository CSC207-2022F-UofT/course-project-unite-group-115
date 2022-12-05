package message_sebd.application_business_rule;

public interface MessageInputBoundary {
    MessageResponseModel create(MessageRequestModel requestModel);
}



