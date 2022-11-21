package interface_adapters;

import MessageUserCase.MessageInputBoundary;
import MessageUserCase.MessageRequestModel;
import MessageUserCase.MessageResponseModel;

public class MessageController {
    final MessageInputBoundary USER_INPUT;

    public MessageController(MessageInputBoundary userInput){
        this.USER_INPUT = userInput;
    }

    MessageResponseModel create(String content, String sender, String receiver){
        MessageRequestModel requestModel = new MessageRequestModel(content, sender, receiver);

        return USER_INPUT.create(requestModel);
    }
}
