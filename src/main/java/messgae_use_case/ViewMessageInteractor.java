package messgae_use_case;

import entity.MessageFactory;
import interface_adapters.MessagePresenter;
import interface_adapters.ViewMessagePresenter;

import java.io.IOException;
import java.util.List;

public class ViewMessageInteractor implements ViewMessageInputBoundary{
    //TODO: Final variables are all capital
    final databases.MessageRepoInt MessageRepoInt;
    final interface_adapters.ViewMessagePresenter ViewMessagePresenter;


    public ViewMessageInteractor(databases.MessageRepoInt MessageRepoInt, interface_adapters.ViewMessagePresenter ViewMessagePresenter) {
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
