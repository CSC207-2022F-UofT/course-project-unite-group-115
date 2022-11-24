package Interface;

import Database.GroupRepoInt;
import Database.UserMessageModel;
import Database.InputBoundary;
import Database.UserMessageResponseModel;

public class UserReporterController {
    final InputBoundary userInput;

    public UserReporterController(InputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public UserMessageResponseModel create(String messageId, String userId, String message,String reportUserId) {
        UserMessageModel requestModel = new UserMessageModel(
                messageId, userId, message, reportUserId);

        return userInput.create(requestModel);
    }
}
