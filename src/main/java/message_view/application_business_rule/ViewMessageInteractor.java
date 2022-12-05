package message_view.application_business_rule;

public class ViewMessageInteractor implements ViewMessageInputBoundary{
    //TODO: Final variables are all capital
    final database_classes.MessageRepoInt MessageRepoInt;;
    final message_view.interface_adaptor.ViewMessagePresenter ViewMessagePresenter;
    //final ViewMessageOutputboundary ViewMessageOutputboundary;

    public ViewMessageInteractor(database_classes.MessageRepoInt MessageRepoInt, message_view.interface_adaptor.ViewMessagePresenter ViewMessagePresenter) {
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
