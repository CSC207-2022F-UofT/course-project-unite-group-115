package MessageUserCase;
import java.time.LocalDateTime;
import Entity.*;
import interface_adapters.MessagePresenter;

public class MessageInteractor implements MessageInputBoundary {
    final MessageDsGateway MessageDsGateway;
    final MessagePresenter MessagePresenter;
    final MessageFactory messageFactory;

    public MessageInteractor(MessageDsGateway MessageDsGateway, MessagePresenter MessagePresenter,
                                 MessageFactory messageFactory) {
        this.MessageDsGateway = MessageDsGateway;
        this.MessagePresenter = MessagePresenter;
        this.messageFactory = messageFactory;
    }


    @Override
    public MessageResponseModel create(MessageRequestModel requestModel) {

        LocalDateTime now = LocalDateTime.now();


        MessageDsRequestModel MessageDsModel = new MessageDsRequestModel(requestModel.getcontent());

        MessageDsGateway.save(MessageDsModel);

        return MessagePresenter.prepareSuccessView(messageResponseModel);
    }

}