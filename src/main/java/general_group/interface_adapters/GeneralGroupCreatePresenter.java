package general_group.interface_adapters;

import general_group.use_case.GeneralGroupCreateDsResponseModel;
import general_group.use_case.GeneralGroupCreateOutputBoundary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeneralGroupCreatePresenter implements GeneralGroupCreateOutputBoundary {
    /**
     * The success view, when the group has been successfully created and saved.
     * @param responseModel The GeneralGroupCreateDsResponseModel returned by the interactor
     * @return The formatted GeneralGroupCreateDsResponseModel
     */
    @Override
    public GeneralGroupCreateDsResponseModel prepareSuccessView(GeneralGroupCreateDsResponseModel responseModel) {
        LocalDateTime responseTime = LocalDateTime.parse(responseModel.getCreationTime());
        responseModel.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return responseModel;
    }

    /**
     * The fail view, throws an exception when the group has not been created
     * @param error a String describing the error that occurred.
     * @return The formatted GeneralGroupCreateDsResponseModel
     */
    @Override
    public GeneralGroupCreateDsResponseModel prepareFailView(String error) {
        throw new GenGroupCreationFailed(error);
    }
}
