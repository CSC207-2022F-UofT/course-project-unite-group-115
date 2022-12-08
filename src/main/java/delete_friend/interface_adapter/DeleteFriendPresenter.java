package delete_friend.interface_adapter;

import delete_friend.application_business_rules.DeleteFriendResponseModel;
import add_friend.interface_adapter.AddFriendFailure;
import delete_friend.application_business_rules.DeleteFriendOutputBoundary;

public class DeleteFriendPresenter  implements DeleteFriendOutputBoundary {
    @Override
    public DeleteFriendResponseModel prepareSuccessView(DeleteFriendResponseModel responseModel) {
        responseModel.setMessage(responseModel.getFriendToDelete() + " was deleted from your friend list!");
        return responseModel;
    }

    @Override
    public DeleteFriendResponseModel prepareFailView(String errorMessage) {
        throw new AddFriendFailure(errorMessage);
    }
}
