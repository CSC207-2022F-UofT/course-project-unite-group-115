package block_user_application.interface_adapters;

import block_user_application.application_business_rules.UserReporterRequestModel;
import block_user_application.application_business_rules.UserReporterInputBoundary;
import block_user_application.application_business_rules.UserReporterResponseModel;

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
