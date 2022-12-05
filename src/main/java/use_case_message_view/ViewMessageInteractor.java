package use_case_message_view;

import databases_message.MessageFile;
import entity_message.MessageFactory;

import java.io.IOException;
import java.util.List;

public class ViewMessageInteractor implements ViewMessageInputBoundary{
    //TODO: Final variables are all capital
    final databases_message.MessageRepoInt MessageRepoInt;;
    final interface_adapters_message.ViewMessagePresenter ViewMessagePresenter;
    //final ViewMessageOutputboundary ViewMessageOutputboundary;

    public ViewMessageInteractor(databases_message.MessageRepoInt MessageRepoInt, interface_adapters_message.ViewMessagePresenter ViewMessagePresenter) {
        this.MessageRepoInt = MessageRepoInt;
        this.ViewMessagePresenter = ViewMessagePresenter;
        //this.ViewMessageOutputboundary = ViewMessageOutputboundary;
    }


    @Override
    public ViewMessageResponseModel create(ViewMessageRequestModel requestModel) {
        String groupID = requestModel.getGroupID();
//        if (MessageRepoInt.getGroupMessageInfo(groupID).isEmpty()) {
//            return ViewMessagePresenter.prepareFailView("No one chat in the group, send your first message!");
//        }
        String sendedmessage = MessageRepoInt.getGroupMessageInfo(groupID);

        ViewMessageResponseModel ViewMessageresponsemodel = new ViewMessageResponseModel(sendedmessage);
        return ViewMessagePresenter.prepareSuccessView(ViewMessageresponsemodel);

    }

}
