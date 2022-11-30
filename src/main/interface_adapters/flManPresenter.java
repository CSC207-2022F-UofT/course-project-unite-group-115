package interface_adapters;

import flManager.application_business_rules.flManResponseModel;

public class flManPresenter {
    public flManResponseModel prepareSuccessView(flManResponseModel friRespMod) {
        return friRespMod;
    }

    public flManResponseModel prepareFailView(String error) throws flCreationFailed {
        throw new flCreationFailed(error);
    }
}
