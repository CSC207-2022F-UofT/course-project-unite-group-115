package interface_adapters_message;

import use_case_message_view.*;

import java.io.IOException;

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
