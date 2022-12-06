package message_view.application_business_rule;

import database_classes.MessageRepoInt;
import message_view.interface_adaptor.ViewMessageFailure;
import message_view.interface_adaptor.ViewMessagePresenter;

public class ViewMessageInteractor implements ViewMessageInputBoundary{
    //TODO: Final variables are all capital
    final database_classes.MessageRepoInt MessageRepoInt;;
    final ViewMessagePresenter ViewMessagePresenter;
    //final ViewMessageOutputboundary ViewMessageOutputboundary;

    public ViewMessageInteractor(database_classes.MessageRepoInt MessageRepoInt, message_view.interface_adaptor.ViewMessagePresenter ViewMessagePresenter) {
        this.MessageRepoInt = MessageRepoInt;
        this.ViewMessagePresenter = ViewMessagePresenter;
        //this.ViewMessageOutputboundary = ViewMessageOutputboundary;
    }


    @Override
    public ViewMessageResponseModel create(ViewMessageRequestModel requestModel) {
        String groupID = requestModel.getGroupID();
        String viewer = requestModel.getViewer();
        String sendedmessage = MessageRepoInt.getGroupMessageInfo(groupID);

        //todo: if the message content is in the sensitive word list for the viewer

        //sendedmessage = blockUser(groupID (sender),viewer, sendedmessage)

        //case 1: no message in the group
        if (!MessageRepoInt.doesGroupExist(groupID)) {
            throw new ViewMessageFailure("No one has sent a message in the group, send your first message!");
        }


        ViewMessageResponseModel ViewMessageresponsemodel = new ViewMessageResponseModel(sendedmessage);
        return ViewMessagePresenter.prepareSuccessView(ViewMessageresponsemodel);

    }

}
