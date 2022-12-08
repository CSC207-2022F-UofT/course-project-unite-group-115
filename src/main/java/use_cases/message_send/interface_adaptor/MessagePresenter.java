package use_cases.message_send.interface_adaptor;

import use_cases.message_send.application_business_rule.MessageOutputBoundary;
import use_cases.message_send.application_business_rule.MessageResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessagePresenter implements MessageOutputBoundary {
    @Override
    public MessageResponseModel prepareSuccessView(MessageResponseModel message){
        LocalDateTime messageTime = LocalDateTime.parse(message.getCreationTime());
        message.setCreationTime(messageTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return message;
    }

    //ToDo: future - add fail review, i.e. sender is in the banned list
    public MessageResponseModel prepareFailView(String error){
        throw new MessageCreationFailed(error);
    }
}
