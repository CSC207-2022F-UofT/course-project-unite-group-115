package flManager.interface_adapters;

import flManager.application_business_rules.flManOutputBoundary;
import flManager.application_business_rules.flManResponseModel;
import flManager.interface_adapters.flCreationFailed;

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
