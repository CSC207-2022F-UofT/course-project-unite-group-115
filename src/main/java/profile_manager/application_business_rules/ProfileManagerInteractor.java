package profile_manager.application_business_rules;

import database_classes.ProfileRepoInt;
import database_classes.ProfileRepoRequestModel;
import entities.Profile;
import entities.ProfileFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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

        String username = requestModel.getUserName();
        List<String> groups = new ArrayList<>();
        List<String> friends = new ArrayList<>();
        String blockedUsers = "";

        if (profileRepoInt.existsByName(username)){
            groups = profileRepoInt.getGroups(username);
            friends = profileRepoInt.getFriends(username);
            // ToDo: future - integrate with reporter use case
            blockedUsers = "";
        }
        Profile profile = ProfileFactory.create(
                username,
                requestModel.getProfileName(),
                requestModel.getDob(),
                requestModel.getDescription(),
                requestModel.getSocialLinks(),
                requestModel.getSensitiveWords(),
                requestModel.getInterests(),
                groups,
                friends,
                blockedUsers
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
