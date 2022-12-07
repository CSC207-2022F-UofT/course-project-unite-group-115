package Block_User_Application.interface_adapters;

import Block_User_Application.application_business_rules.UserReporterRequestModel;
import Block_User_Application.application_business_rules.UserReporterInputBoundary;
import Block_User_Application.application_business_rules.UserReporterResponseModel;

public class UserReporterController {
    final UserReporterInputBoundary userInput;

    public UserReporterController(UserReporterInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public UserReporterResponseModel create(String messageId, String userId, String message, String reportUserId) {
        UserReporterRequestModel requestModel = new UserReporterRequestModel(
                messageId, userId, message, reportUserId);

        return userInput.create(requestModel);
    }
}
