package use_case_message_view;

import entity_message.MessageFactory;

import java.io.IOException;
import java.util.List;

public class ViewMessageInteractor implements ViewMessageInputBoundary{
    //TODO: Final variables are all capital
    final databases_message.MessageRepoInt MessageRepoInt;
    final interface_adapters_message.ViewMessagePresenter ViewMessagePresenter;


    public ViewMessageInteractor(databases_message.MessageRepoInt MessageRepoInt, interface_adapters_message.ViewMessagePresenter ViewMessagePresenter) {
        this.MessageRepoInt = MessageRepoInt;
        this.ViewMessagePresenter = ViewMessagePresenter;
    }


    @Override
    public ViewMessageResponseModel create(ViewMessageRequestModel requestModel) throws IOException {

        String groupID = requestModel.getGroupID();

        List<String> sendedmessage = MessageRepoInt.getGroupMessageInfo(groupID);

        ViewMessageResponseModel ViewMessageresponsemodel = new ViewMessageResponseModel(sendedmessage);
        return ViewMessagePresenter.prepareSuccessView(ViewMessageresponsemodel);

        // todo: prepare fail review.
    }

}
