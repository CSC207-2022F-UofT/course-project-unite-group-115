package MessageUserCase;
import java.time.LocalDateTime;
import entity.*
import interface_adapters.EditmessagePresenter

public class EditMessageInteractor implements EditMessageInputBoundary {
    final EditMessageDsGateway editMessageDsGateway;
    final EditMessagePresenter editMessagePresenter;
    final MessageFactory messageFactory;

    public EditMessageInteractor(EditMessageDsGateway editMessageDsGateway, EditMessagePresenter editMessagePresenter,
                                 MessageFactory messageFactory) {
        this.editMessageDsGateway = editMessageDsGateway;
        this.editMessagePresenter = editMessagePresenter;
    }


    @Override
    public EditMessageResponseModel create(EditMessageRequestModel requestModel) {

        LocalDateTime now = LocalDateTime.now();
        EditMessageDsRequestModel EditMessageDsModel = new EditMessageDsRequestModel(requestModel.getcontent());


        EditMessageDsGateway.save(EditMessageDsModel);

        EditMessageResponseModel editmessageResponseModel = new EditMessageResponseModel(???);
        return EditMessagePresenter.prepareSuccessView(editmessageResponseModel);
    }

}