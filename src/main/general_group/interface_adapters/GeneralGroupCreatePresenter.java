package general_group.interface_adapters;

import general_group.use_case.GeneralGroupCreateDsResponseModel;
import general_group.use_case.GeneralGroupCreateOutputBoundary;

public class GeneralGroupCreatePresenter implements GeneralGroupCreateOutputBoundary {
    @Override
    public GeneralGroupCreateDsResponseModel prepareSuccessView(GeneralGroupCreateDsResponseModel group) {
        return null;
    }

    @Override
    public GeneralGroupCreateDsResponseModel prepareFailView(String error) {
        return null;
    }
}
