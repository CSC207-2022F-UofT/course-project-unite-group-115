package interface_adapters_message;

import use_case_message_view.*;

import java.io.IOException;

public class ViewMessageController {
    final ViewMessageInputBoundary Message_INPUT; //group_id

    public ViewMessageController(ViewMessageInputBoundary MessageInput) {
        this.Message_INPUT = MessageInput;
    }

    public ViewMessageResponseModel create(String groupID) throws IOException {  //may not need input
        ViewMessageRequestModel requestModel = new ViewMessageRequestModel(groupID);
        return Message_INPUT.create(requestModel);
    }
}
