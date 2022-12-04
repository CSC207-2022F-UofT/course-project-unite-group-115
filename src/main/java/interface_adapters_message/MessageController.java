package interface_adapters_message;

import use_case_message_send.MessageInputBoundary;
import use_case_message_send.MessageRequestModel;
import use_case_message_send.MessageResponseModel;

public class MessageController {
    final MessageInputBoundary Message_INPUT;

    public MessageController(MessageInputBoundary MessageInput){
        this.Message_INPUT = MessageInput;
    }

    public MessageResponseModel create(String content, String sender, String groupID){
        MessageRequestModel requestModel = new MessageRequestModel(content, sender, groupID);

        return Message_INPUT.create(requestModel);
    }
}
