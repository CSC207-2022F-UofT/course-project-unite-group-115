package use_case_message_send;

import databases_message.MessageDsRequestModel;
import databases_message.MessageRepoInt;
import entity_message.Message;
import entity_message.MessageFactory;
import interface_adapters_message.MessagePresenter;

import java.time.LocalDateTime;

public class MessageInteractor implements MessageInputBoundary {
    final databases_message.MessageRepoInt MessageRepoInt;
    final MessagePresenter MessagePresenter;
    final MessageFactory messageFactory;

    public MessageInteractor(MessageRepoInt MessageRepoInt, MessagePresenter MessagePresenter,
                             MessageFactory messageFactory) {
        this.MessageRepoInt = MessageRepoInt;
        this.MessagePresenter = MessagePresenter;
        this.messageFactory = messageFactory;
    }


    @Override
    public MessageResponseModel create(MessageRequestModel requestModel) {

        Message message = MessageFactory.create(requestModel.getContent(), requestModel.getSender(), requestModel.getGroupID());
        LocalDateTime now = LocalDateTime.now();

        MessageDsRequestModel MessageDsModel =
                new MessageDsRequestModel(message.getContent(), message.getSender(), message.getGroupID(), message.getID().toString(),message.getReaction(),now);
        MessageRepoInt.save(MessageDsModel);

        MessageResponseModel Messageresponsemodel = new MessageResponseModel(message.getSender(),now.toString());
        return MessagePresenter.prepareSuccessView(Messageresponsemodel);

        //todo: prepare fail review.
    }

}