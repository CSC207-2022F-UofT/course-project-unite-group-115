package random_grouper.interface_adapters;

import random_grouper.application_business_rules.RanGroupCreateOutputBoundary;
import random_grouper.application_business_rules.RanGroupCreateResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class RanGroupCreatePresenter implements RanGroupCreateOutputBoundary {
    @Override
    public RanGroupCreateResponseModel prepareSuccessView(RanGroupCreateResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    @Override
    public RanGroupCreateResponseModel prepareFailView(String errorMessage) {
        throw new GroupCreationFailed(errorMessage);
    }
}
