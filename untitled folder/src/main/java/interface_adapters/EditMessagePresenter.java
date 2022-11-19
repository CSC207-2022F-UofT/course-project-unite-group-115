
import MessageUserCase.EditMessageResponseModel;
import MessageUserCase.MessageResponseModel;
import MessageUserCase.EditMessageOutputBoundary;



public class EditMessagePresenter implements EditMessageOutputBoundary {
    @Override
    public EditMessageResponseModel prepareSuccessView(EditMessageResponseModel response) {
        setSuccessMessage("Your new message were successfully sended" );
        return response;
    }

    public MessageResponseModel prepareFailView(String error){
        throw new UserCreationFailed(error);
    }
}