package use_cases.message_view.application_business_rule;

import use_cases.message_view.interface_adaptor.ViewMessageFailure;
import use_cases.message_view.interface_adaptor.ViewMessagePresenter;

public class ViewMessageInteractor implements ViewMessageInputBoundary{
    final database_classes.MessageRepoInt MessageRepoInt;;
    final ViewMessagePresenter ViewMessagePresenter;
    //final ViewMessageOutputboundary ViewMessageOutputboundary;

    public ViewMessageInteractor(database_classes.MessageRepoInt MessageRepoInt, use_cases.message_view.interface_adaptor.ViewMessagePresenter ViewMessagePresenter) {
        this.MessageRepoInt = MessageRepoInt;
        this.ViewMessagePresenter = ViewMessagePresenter;
        //this.ViewMessageOutputboundary = ViewMessageOutputboundary;
    }


    @Override
    public ViewMessageResponseModel create(ViewMessageRequestModel requestModel) {
        String groupID = requestModel.getGroupID();
        String viewer = requestModel.getViewer();
        String sendedmessage = MessageRepoInt.getGroupMessageInfo(groupID);

        //ToDo: future - if the message content is in the sensitive word list for the viewer

        //case 1: no message in the group
        if (!MessageRepoInt.doesGroupExist(groupID)) {
            throw new ViewMessageFailure("No one has sent a message in the group yet, sending your first message!");
        }


        ViewMessageResponseModel ViewMessageresponsemodel = new ViewMessageResponseModel(sendedmessage);
        return ViewMessagePresenter.prepareSuccessView(ViewMessageresponsemodel);

    }

}
