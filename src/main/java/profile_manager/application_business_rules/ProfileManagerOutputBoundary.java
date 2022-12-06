package profile_manager.application_business_rules;

public interface ProfileManagerOutputBoundary {
    ProfileManagerResponseModel prepareSuccessView(ProfileManagerResponseModel user);

    ProfileManagerResponseModel prepareFailView(String error);
}
