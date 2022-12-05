package Interface;

import Reporter_Database.UserMessageModel;
import Reporter_Database.InputBoundary;
import Reporter_Database.UserMessageResponseModel;

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
