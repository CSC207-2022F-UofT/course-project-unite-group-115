package profile_manager.frameworks_and_drivers;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import profile_manager.application_business_rules.ProfileRepoInt;
import profile_manager.application_business_rules.ProfileRepoRequestModel;

public class ProfileManagerDataAccess implements ProfileRepoInt {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, ProfileRepoRequestModel> accounts = new HashMap<>();
    public ProfileManagerDataAccess(String csvFilePath) throws IOException {
        csvFile = new File(csvFilePath);

        headers.put("userName", 0);
        headers.put("profileName", 1);
        headers.put("dob", 2);
        headers.put("description", 3);
        headers.put("socialLinks", 4);
        headers.put("sensitiveWords", 5);
        headers.put("interests", 6);
        headers.put("groups", 7);
        headers.put("friends", 8);
        headers.put("blockedUsers", 9);
        headers.put("creationTime", 10);

        if (csvFile.length() == 0) {
            save();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String userName = String.valueOf(col[headers.get("userName")]);

                String profileName = String.valueOf(col[headers.get("profileName")]);
                LocalDate dob = LocalDate.parse(col[headers.get("dob")]);
                String description = String.valueOf(col[headers.get("description")]);

                String socialLinks = String.valueOf(col[headers.get("socialLinks")]);
                List<String> socialLinksList = Arrays.asList(socialLinks.split(";"));

                String sensitiveWords = String.valueOf(col[headers.get("sensitiveWords")]);
                List<String> sensitiveWordsList = Arrays.asList(sensitiveWords.split(";"));

                String interests = String.valueOf(col[headers.get("interests")]);
                List<String> interestsList = Arrays.asList(interests.split(";"));

                String groups = String.valueOf(col[headers.get("groups")]);
                List<String> groupsList = Arrays.asList(groups.split(";"));

                String friends = String.valueOf(col[headers.get("friends")]);
                List<String> friendsList = Arrays.asList(friends.split(";"));

                String blockedUsers = String.valueOf(col[headers.get("blockedUsers")]);
                List<String> blockedUsersList = Arrays.asList(blockedUsers.split(";"));

                String creationTimeText = String.valueOf(col[headers.get("creationTime")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);

                ProfileRepoRequestModel user = new ProfileRepoRequestModel(
                        userName, profileName, dob, description, socialLinksList, sensitiveWordsList, interestsList, groupsList, friendsList, blockedUsersList , ldt);
                accounts.put(userName, user);
            }

            reader.close();
        }
    }

    /**
     * Add requestModel to storage.
     * @param requestModel the user information to save.
     */
    @Override
    public void save(ProfileRepoRequestModel requestModel) {
        accounts.put(requestModel.getUserName(), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (ProfileRepoRequestModel profile : accounts.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
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
                        profile.getCreationTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

}
