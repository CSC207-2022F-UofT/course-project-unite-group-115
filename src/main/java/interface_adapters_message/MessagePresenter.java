package interface_adapters_message;

import use_case_message_send.MessageOutputBoundary;
import use_case_message_send.MessageResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class MessagePresenter implements MessageOutputBoundary {
    @Override
    public MessageResponseModel prepareSuccessView(MessageResponseModel message){
        LocalDateTime messageTime = LocalDateTime.parse(message.getCreationTime());
        message.setCreationTime(messageTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return message;
    }

    //TODO: add fail review, i.e. sender is in the banned list
    public MessageResponseModel prepareFailView(String error){
        throw new MessageCreationFailed(error);
    }
}
