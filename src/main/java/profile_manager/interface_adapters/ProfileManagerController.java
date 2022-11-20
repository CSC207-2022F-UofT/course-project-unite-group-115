package profile_manager.interface_adapters;

import profile_manager.application_business_rules.ProfileManagerInputBoundary;
import profile_manager.application_business_rules.ProfileManagerRequestModel;
import profile_manager.application_business_rules.ProfileManagerResponseModel;

import java.time.LocalDate;
import java.util.ArrayList;

// Interface adapters layer

public class ProfileManagerController {

    final ProfileManagerInputBoundary userInput;

    public ProfileManagerController(ProfileManagerInputBoundary accountGateway) {
        this.userInput = accountGateway;
    }

    public ProfileManagerResponseModel create(String userName,
                                              String profileName,
                                              LocalDate dob,
                                              String description,
                                              ArrayList<String> socialLinks,
                                              ArrayList<String> sensitiveWords,
                                              ArrayList<String> interests,
                                              ArrayList<String> groups,
                                              ArrayList<String> friends,
                                              ArrayList<String> blockedUsers) {

        ProfileManagerRequestModel requestModel = new ProfileManagerRequestModel(
                userName, profileName, dob, description, socialLinks, sensitiveWords, interests, groups, friends, blockedUsers);

        return userInput.create(requestModel);
    }
}
