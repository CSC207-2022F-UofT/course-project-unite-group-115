package interface_adapters;

import messgae_use_case.*;

public class ViewMessageController {
    final ViewMessageInputBoundary USER_INPUT; //group_id

    public ViewMessageController(ViewMessageInputBoundary userInput) {
        this.USER_INPUT = userInput;
    }

    public ViewMessageResponseModel create(String groupID) {
        ViewMessageRequestModel requestModel = new ViewMessageRequestModel(groupID);
        return USER_INPUT.create(requestModel);
    }
}
