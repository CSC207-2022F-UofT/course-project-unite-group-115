package entities;

import java.time.LocalDate;
import java.util.ArrayList;

public class ProfileFactory{
    public static Profile create(String profileName,
                                 LocalDate dob,
                                 String description,
                                 ArrayList<String> socialLinks,
                                 ArrayList<String> sensitiveWords,
                                 ArrayList<String> interests,
                                 ArrayList<String> groups,
                                 ArrayList<String> friends,
                                 ArrayList<String> blockedUsers) {

        return new Profile(
                profileName, dob, description, socialLinks, sensitiveWords, interests, groups, friends, blockedUsers);
    }
}
