package user_register.frameworks_and_drivers;

import java.awt.*;
import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.List;

import user_register.application_business_rules.UserRepoInt;
import user_register.application_business_rules.UserRepoRequestModel;

import javax.swing.*;

public class UserDataAccess implements UserRepoInt {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, UserRepoRequestModel> accounts = new HashMap<>();
    public UserDataAccess(String csvFilePath) throws IOException {
        csvFile = new File(csvFilePath);

        headers.put("userName", 0);
        headers.put("password", 1);
        headers.put("creationTime", 2);
        headers.put("profileName", 3);
        headers.put("dob", 4);
        headers.put("description", 5);
        headers.put("socialLinks", 6);
        headers.put("sensitiveWords", 7);
        headers.put("interests", 8);
        headers.put("groups", 9);
        headers.put("friends", 10);
        headers.put("blockedUsers", 11);

        if (csvFile.length() == 0) {
            save();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String userName = String.valueOf(col[headers.get("userName")]);
                String password = String.valueOf(col[headers.get("password")]);

                String creationTimeText = String.valueOf(col[headers.get("creationTime")]);
                LocalDateTime ldt = LocalDateTime.parse(creationTimeText);

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

                UserRepoRequestModel user = new UserRepoRequestModel(userName, password, ldt);
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
    public void save(UserRepoRequestModel requestModel) {
        accounts.put(requestModel.getName(), requestModel);
        this.save();
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (UserRepoRequestModel user : accounts.values()) {
                String line = String.format("%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,%s",
                        user.getName(), user.getPassword(), user.getCreationTime(),
                        "null", LocalDate.of(0000, 1, 1), "null",
                        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>(),
                        new ArrayList<String>(), new ArrayList<String>(), new ArrayList<String>());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

//    public List<String> getGroups(String username) {
//        List<String> listOfGroupIds = new ArrayList<String>();
//        try{
//            final Map<String, Integer> headers = new LinkedHashMap<>();
//            headers.put("userName", 0);
//            headers.put("password", 1);
//            headers.put("creationTime", 2);
//            headers.put("profileName", 3);
//            headers.put("dob", 4);
//            headers.put("description", 5);
//            headers.put("socialLinks", 6);
//            headers.put("sensitiveWords", 7);
//            headers.put("interests", 8);
//            headers.put("groups", 9);
//            headers.put("friends", 10);
//            headers.put("blockedUsers", 11);
//
//            BufferedReader reader = new BufferedReader(new FileReader("./src/main/java/databases/users.csv"));
//            reader.readLine(); // skip header
//            String row;
//
//            while ((row = reader.readLine()) != null) {
//                String[] col = row.split(",");
//                if (Objects.equals(String.valueOf(col[headers.get("userName")]), username)) {
//                    String groups = String.valueOf(col[headers.get("groups")]);
//                    List<String> groupsList = Arrays.asList(groups.split(";"));
//                    listOfGroupIds = groupsList;
//                }
//            }
//            reader.close();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return listOfGroupIds;
//    }

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
