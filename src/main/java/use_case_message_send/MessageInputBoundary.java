package use_case_message_send;

public interface MessageInputBoundary {
    MessageResponseModel create(MessageRequestModel requestModel);
}



