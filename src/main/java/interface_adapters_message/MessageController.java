package interface_adapters_message;

import use_case_message_send.MessageInputBoundary;
import use_case_message_send.MessageRequestModel;
import use_case_message_send.MessageResponseModel;

public class MessageController {
    final MessageInputBoundary USER_INPUT;

    public MessageController(MessageInputBoundary userInput){
        this.USER_INPUT = userInput;
    }

    public MessageResponseModel create(String content, String sender, String groupID){
        MessageRequestModel requestModel = new MessageRequestModel(content, sender, groupID);

        return USER_INPUT.create(requestModel);
    }
}
