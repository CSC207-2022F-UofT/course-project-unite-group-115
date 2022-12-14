package use_cases.message_view.interface_adaptor;

import use_cases.message_view.application_business_rule.ViewMessageInputBoundary;
import use_cases.message_view.application_business_rule.ViewMessageRequestModel;
import use_cases.message_view.application_business_rule.ViewMessageResponseModel;

public class ViewMessageController {
    static ViewMessageInputBoundary ViewMessage_INPUT = null; //group_id
    String viewer;

    public ViewMessageController(ViewMessageInputBoundary viewMessageInput) {
        this.ViewMessage_INPUT = viewMessageInput;
    }

    public static ViewMessageResponseModel create(String groupID, String viewer) {  //may not need input
        ViewMessageRequestModel requestModel = new ViewMessageRequestModel(groupID, viewer);
        return ViewMessage_INPUT.create(requestModel);
    }
}
