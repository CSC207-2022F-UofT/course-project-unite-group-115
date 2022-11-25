package interface_adapters;

import MessageUserCase.MessageInputBoundary;
import MessageUserCase.MessageRequestModel;
import MessageUserCase.MessageResponseModel;

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
