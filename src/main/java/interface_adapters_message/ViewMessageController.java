package interface_adapters_message;

import use_case_message_view.*;

import java.io.IOException;

public class ViewMessageController {
    final ViewMessageInputBoundary USER_INPUT; //group_id

    public ViewMessageController(ViewMessageInputBoundary userInput) {
        this.USER_INPUT = userInput;
    }

    public ViewMessageResponseModel create(String groupID) throws IOException {  //may not need input
        ViewMessageRequestModel requestModel = new ViewMessageRequestModel(groupID);
        return USER_INPUT.create(requestModel);
    }
}
