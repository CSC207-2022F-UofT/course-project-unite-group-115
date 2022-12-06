package profile_manager.interface_adapters;

import profile_manager.application_business_rules.ProfileManagerOutputBoundary;
import profile_manager.application_business_rules.ProfileManagerResponseModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ProfileManagerPresenter implements ProfileManagerOutputBoundary {
    @Override
    public ProfileManagerResponseModel prepareSuccessView(ProfileManagerResponseModel response) {
        LocalDateTime responseTime = LocalDateTime.parse(response.getCreationTime());
        response.setCreationTime(responseTime.format(DateTimeFormatter.ofPattern("hh:mm:ss")));
        return response;
    }

    public ProfileManagerResponseModel prepareFailView(String error){
        throw new ProfileCreationFailed(error);
    }
}
