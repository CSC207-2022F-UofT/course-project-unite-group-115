package add_friend.interface_adapter;

import add_friend.application_business_rules.AddFriendResponseModel;
import add_friend.application_business_rules.AddFriendOutputBoundary;

public class AddFriendPresenter implements AddFriendOutputBoundary {
    @Override
    public AddFriendResponseModel prepareSuccessView(AddFriendResponseModel responseModel) {
        responseModel.setMessage(responseModel.getNewFriend() + " was added as a new friend!");
        return responseModel;
    }

    @Override
    public AddFriendResponseModel prepareFailView(String errorMessage) {
        throw new AddFriendFailure(errorMessage);
    }
}
