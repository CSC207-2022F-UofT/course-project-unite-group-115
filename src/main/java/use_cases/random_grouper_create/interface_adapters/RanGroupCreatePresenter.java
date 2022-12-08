package use_cases.random_grouper_create.interface_adapters;

import use_cases.random_grouper_create.application_business_rules.RanGroupCreateOutputBoundary;
import use_cases.random_grouper_create.application_business_rules.RanGroupCreateResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RanGroupCreatePresenter implements RanGroupCreateOutputBoundary {

    /**
     * Formats the information stored in the RanGroupCreateResponseModel data structure when group creation was
     * succuessful.
     * @param response the RanGroupCreateResponseModel returned by the interactor
     * @return returns a formatted RanGroupCreateResponseModel
     */
    @Override
    public RanGroupCreateResponseModel prepareSuccessView(RanGroupCreateResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    /**
     * Throws a GroupCreationFailure error.
     * @param errorMessage a String describing the error that occurred
     */
    @Override
    public RanGroupCreateResponseModel prepareFailView(String errorMessage) {
        throw new GroupCreationFailure(errorMessage);
    }
}
