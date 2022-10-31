package MessageUserCase;

public class EditMessageInteractor implements EditMessageInputBoundary {
    final EditMessageDsGateway editMessageDsGateway;
    final EditMessagePresenter editMessagePresenter;
    final MessageFactory messageFactory;

    public EditMessageInteractor(EditMessageDsGateway editMessageDsGateway, EditMessagePresenter editMessagePresenter,
                                 MessageFactory messageFactory) {
        this.editMessageDsGateway = editMessageDsGateway;
        this.editMessagePresenter = editMessagePresenter;
        this.messageFactory = messageFactory;      //?
    }


}