package use_cases.profile_manager.application_business_rules;

public interface ProfileManagerInputBoundary {
    ProfileManagerResponseModel create(ProfileManagerRequestModel requestModel);
}
