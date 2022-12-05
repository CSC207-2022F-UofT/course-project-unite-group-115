package message_sebd.interface_adaptor;

import message_sebd.application_business_rule.MessageInputBoundary;
import message_sebd.application_business_rule.MessageRequestModel;
import message_sebd.application_business_rule.MessageResponseModel;

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
