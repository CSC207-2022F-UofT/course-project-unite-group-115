package friend_manager.interface_adapters;

import friend_manager.application_business_rules.flManOutputBoundary;
import friend_manager.application_business_rules.flManResponseModel;

import java.util.List;

public class flManPresenter implements flManOutputBoundary {
    public flManResponseModel prepareSuccessView(flManResponseModel friRespMod) {
        String owner = friRespMod.getOwner();
        List<String> friends = friRespMod.getFriends();
        friRespMod.setSuccessMessage("You were successfully loaded " + owner +
                "'s friend list: " + friends.toString() + ".");
        return friRespMod;

    }

    public flManResponseModel prepareFailView(String error) throws flCreationFailed {
        throw new flCreationFailed(error);
    }
}
