package use_cases.delete_friend.interface_adapter;

import use_cases.delete_friend.application_business_rules.DeleteFriendResponseModel;
import use_cases.add_friend.interface_adapter.AddFriendFailure;
import use_cases.delete_friend.application_business_rules.DeleteFriendOutputBoundary;

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
