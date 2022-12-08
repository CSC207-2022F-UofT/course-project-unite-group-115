package use_cases.add_friend.interface_adapter;

import use_cases.add_friend.application_business_rules.AddFriendResponseModel;
import use_cases.add_friend.application_business_rules.AddFriendOutputBoundary;

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
