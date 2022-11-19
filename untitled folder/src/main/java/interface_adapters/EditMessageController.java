package interface_adapters;
import MessageUserCase.EditMessageInputBoundary;
import MessageUserCase.EditMessageRequestModel;
import MessageUserCase.EditMessageResponseModel;
import User;

public class EditMessageController {

    final EditMessageController userInput;

    public EditMessageController(EditMessageInputBoundary userInput) {
        this.userInput = userInput;
    }

    public EditMessageResponseModel create(String content, User sender, User receiver) {
        EditMessageRequestModel requestModel = new EditMessageRequestModel(
                content, sender, receiver);

        return userInput.create(requestModel);
    }
}
