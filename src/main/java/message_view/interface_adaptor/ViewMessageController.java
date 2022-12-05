package message_view.interface_adaptor;

import message_view.application_business_rule.ViewMessageInputBoundary;
import message_view.application_business_rule.ViewMessageRequestModel;
import message_view.application_business_rule.ViewMessageResponseModel;

public class ViewMessageController {
    static ViewMessageInputBoundary ViewMessage_INPUT = null; //group_id

    public ViewMessageController(ViewMessageInputBoundary viewMessageInput) {
        this.ViewMessage_INPUT = viewMessageInput;
    }

    public static ViewMessageResponseModel create(String groupID) {  //may not need input
        ViewMessageRequestModel requestModel = new ViewMessageRequestModel(groupID);
        return ViewMessage_INPUT.create(requestModel);
    }
}
