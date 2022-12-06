package message_send.application_business_rule;

import database_classes.MessageRepoRequestModel;
import database_classes.MessageRepoInt;
import entities.Message;
import entities.MessageFactory;
import message_send.interface_adaptor.MessagePresenter;

import java.time.LocalDateTime;

public class MessageInteractor implements MessageInputBoundary {
    final MessageRepoInt MessageRepoInt;
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
        //case 1: the message contetn is not valid.
        if (!message.contentIsValid()) {
            return MessagePresenter.prepareFailView("Message content can not be empty or only one letter.");
        }
        //todo: case 2: user in the block list

        LocalDateTime now = LocalDateTime.now();

        MessageRepoRequestModel MessageDsModel =
                new MessageRepoRequestModel(message.getContent(), message.getSender(), message.getGroupID(), message.getID().toString(),message.getReaction(),now);
        MessageRepoInt.save(MessageDsModel);

        MessageResponseModel Messageresponsemodel = new MessageResponseModel(message.getSender(),now.toString());
        return MessagePresenter.prepareSuccessView(Messageresponsemodel);

    }

}