package general_group.interface_adapters;

import general_group.use_case.GeneralGroupCreateDsResponseModel;
import general_group.use_case.GeneralGroupCreateOutputBoundary;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GeneralGroupCreatePresenter implements GeneralGroupCreateOutputBoundary {
    @Override
    public GeneralGroupCreateDsResponseModel prepareSuccessView(GeneralGroupCreateDsResponseModel responseModel) {
        LocalDateTime responseTime = LocalDateTime.parse(responseModel.getCreationTime());
        responseModel.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return responseModel;
    }

    @Override
    public GeneralGroupCreateDsResponseModel prepareFailView(String error) {
        throw new GenGroupCreationFailed(error);
    }
}
