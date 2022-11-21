package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProfileFactory{
    public static Profile create(String userName,
                                 String profileName,
                                 LocalDate dob,
                                 String description,
                                 List<String> socialLinks,
                                 List<String> sensitiveWords,
                                 List<String> interests,
                                 List<String> groups,
                                 List<String> friends,
                                 List<String> blockedUsers) {

        return new Profile(
                userName, profileName, dob, description, socialLinks, sensitiveWords, interests, groups, friends, blockedUsers);
    }
}
