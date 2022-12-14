package use_cases.message_send.interface_adaptor;

import use_cases.message_send.application_business_rule.MessageInputBoundary;
import use_cases.message_send.application_business_rule.MessageRequestModel;
import use_cases.message_send.application_business_rule.MessageResponseModel;

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
