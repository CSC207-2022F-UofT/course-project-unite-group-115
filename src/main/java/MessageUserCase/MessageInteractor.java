package MessageUserCase;

import Entity.Message;
import Entity.MessageFactory;
import interface_adapters.MessagePresenter;

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

        Message message = MessageFactory.create(requestModel.getContent(), requestModel.getSender(), requestModel.getReceiver());
        LocalDateTime now = LocalDateTime.now();

        MessageDsRequestModel MessageDsModel = new MessageDsRequestModel(message.getContent(), message.getSender(), message.getReceiver(), now);
        MessageRepoInt.save(MessageDsModel);

        MessageResponseModel Messageresponsemodel = new MessageResponseModel(message.getSender(),now.toString()); //?
        return MessagePresenter.prepareSuccessView(Messageresponsemodel);
    }

}