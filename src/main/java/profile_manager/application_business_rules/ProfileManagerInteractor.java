package profile_manager.application_business_rules;

import entities.Profile;
import entities.ProfileFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import profile_manager.interface_adapters.ProfileManagerPresenter;

// Use case layer

public class ProfileManagerInteractor implements ProfileManagerInputBoundary {

    final ProfileRepoInt profileRepoInt;
    final ProfileManagerPresenter profileManagerPresenter;
    final ProfileFactory profileFactory;

    public ProfileManagerInteractor(ProfileRepoInt profileRepoInt, ProfileManagerPresenter profileManagerPresenter,
                                  ProfileFactory profileFactory) {
        this.profileRepoInt = profileRepoInt;
        this.profileManagerPresenter = profileManagerPresenter;
        this.profileFactory = profileFactory;
    }

    @Override
    public ProfileManagerResponseModel create(ProfileManagerRequestModel requestModel) {
//        String profileName = requestModel.getProfileName();
//        LocalDate dob = requestModel.getDob();
//        String description =requestModel.getDescription();
//        List<String> socialLinks = requestModel.getSocialLinks();
//        List<String> sensitiveWords = requestModel.getSensitiveWords();
//        List<String> interests = requestModel.getInterests();
//        List<String> groups = requestModel.getGroups();
//        List<String> friends = requestModel.getFriends();
//        List<String> blockedUsers = requestModel.getBlockedUsers();

        Profile profile = ProfileFactory.create(
//                profileName, dob, description, socialLinks, sensitiveWords, interests, groups, friends, blockedUsers
                requestModel.getUserName(),
                requestModel.getProfileName(),
                requestModel.getDob(),
                requestModel.getDescription(),
                requestModel.getSocialLinks(),
                requestModel.getSensitiveWords(),
                requestModel.getInterests(),
                requestModel.getGroups(),
                requestModel.getFriends(),
                requestModel.getBlockedUsers()
        );

        LocalDateTime now = LocalDateTime.now();
        ProfileRepoRequestModel userDsModel = new ProfileRepoRequestModel(
                profile.getUserName(),
                profile.getProfileName(),
                profile.getDob(),
                profile.getDescription(),
                profile.getSocialLinks(),
                profile.getSensitiveWords(),
                profile.getInterests(),
                profile.getGroups(),
                profile.getFriends(),
                profile.getBlockedUsers(),
                now);

        profileRepoInt.save(userDsModel);

        ProfileManagerResponseModel accountResponseModel = new ProfileManagerResponseModel(profile.getUserName(), now.toString());
        return profileManagerPresenter.prepareSuccessView(accountResponseModel);
    }
}
