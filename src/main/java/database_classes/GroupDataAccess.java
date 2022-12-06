package database_classes;

import general_group.use_case.GeneralGroupRepoInt;
import random_grouper_create.application_business_rules.RanGroupCreateDataAccessInt;
import random_grouper_request_group.application_business_rules.ReqRanGroupDataAccessInt;

import java.io.*;
import java.util.*;

public class GroupDataAccess implements GroupRepoInt, RanGroupCreateDataAccessInt, ReqRanGroupDataAccessInt, GeneralGroupRepoInt {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, GroupRepoRequestModel> groups = new HashMap<>();

    /**
     * Opens and reads the GroupDatabase (csv file) and puts the read information into a Map.
     * Each key is a string representation of a group ID and its corresponding value is a data structure
     * (<GroupRepoRequestModel>) that contains all the information about the group that was stored in the
     * GroupDatabase (group name, ID, interests, members and whether it's a random group).
     *
     * @param csvFilePath path to csv file that acts as the GroupDatabase
     * @throws IOException throws exception if there is an error related to reading the file
     */
    public GroupDataAccess (String csvFilePath) throws IOException {
        this.csvFile = new File(csvFilePath);

        headers.put("group name", 0);
        headers.put("group ID", 1);
        headers.put("members", 2);
        headers.put("interests", 3);
        headers.put("is random group?", 4);

        if (csvFile.length() == 0) {
            save();
        } else {
            BufferedReader reader = new BufferedReader(new FileReader(csvFile));
            reader.readLine(); // skip header

            String row;
            while ((row = reader.readLine()) != null) {
                String[] col = row.split(",");
                String groupName = String.valueOf(col[headers.get("group name")]);
                String groupID = String.valueOf(col[headers.get("group ID")]);
                String members = String.valueOf(col[headers.get("members")]);
                List<String> membersList = Arrays.asList(members.split(";"));
                String interests = String.valueOf(col[headers.get("interests")]);
                List<String> interestsList = Arrays.asList(interests.split(";"));
                String isRandom = String.valueOf(col[headers.get("is random group?")]);
                GroupRepoRequestModel group = new GroupRepoRequestModel(groupName, groupID, interestsList,
                        membersList, isRandom.equals("true"));
                groups.put(groupID, group);
            }

            reader.close();
        }
    }

    /**
     * Writes all group information from the <groups> instance variable (Map) to the GroupDatabase csv file.
     */
    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (GroupRepoRequestModel group : groups.values()) {
                String line = String.format("%s,%s,%s,%s,%s", group.getName(), group.getID(), String.join(";",
                        group.getMembers()), String.join(";", group.getInterests()), group.isRandom());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Add the group information from requestModel into the GroupDatabase file.
     *
     * @param requestModel information about group to save
     */
    @Override
    public void addGroup(GroupRepoRequestModel requestModel){
        groups.put(requestModel.getID(), requestModel);
        this.save();
    }


    /**
     * Remove the group with ID, groupID, from the GroupDatabase file.
     *
     * @param groupID group's ID
     */
    @Override
    public void removeGroup(String groupID) {
        groups.remove(groupID);
        this.save();
    }

    /**
     * Return a map of information about the group with ID, groupID. Each key is a String indicating the
     * information provided by the key.
     * Each map contains the following keys and their associated values:
     *      "group name" -> String of the group's name
     *      "group ID" -> String form of group's ID
     *      "members" -> List of Strings where each String is a members name
     *      "interests" -> List of Strings where each String is one of the group's interests
     *      "random group?" -> boolean value of whether group is a random group
     *
     * @param groupID the ID of a group
     * @return returns a Map containing information about the group with ID <groupID>
     */
    @Override
    public Map<String, Object> getGroupInfo(String groupID) {
        GroupRepoRequestModel requestModel = groups.get(groupID);
        Map<String, Object> result = new HashMap<>();
        result.put("group name", requestModel.getName());
        result.put("group ID", requestModel.getID());
        result.put("members",requestModel.getMembers());
        result.put("interests", requestModel.getInterests());
        result.put("random group?", requestModel.isRandom());
        return result;
    }

    /**
     * Update the GroupDatabase by adding User with name, <userName>, to the members of the group with the ID,
     * <groupID>.
     *
     * @param userName name of an existing User
     * @param groupID  group's ID
     */
    @Override
    public void addUserToGroup(String userName, String groupID) {
        List<String> members = new ArrayList<>(groups.get(groupID).getMembers());
        members.add(userName);
        groups.get(groupID).setMembers(members);
        this.save();
    }

    @Override
    public void removeUserFromGroup(String userName, String groupID) {
        List<String> members = new ArrayList<>(groups.get(groupID).getMembers());
        members.remove(userName);
        groups.get(groupID).setMembers(members);
        this.save();
    }



    /**
     * Update the GroupDatabase by adding interests, <newInterests>, to the existing interests of the group with the
     * ID, <groupID>.
     *
     * @param newInterests list of interests to be added to the group
     * @param groupID   group's ID
     */
    @Override
    public void addInterestsToGroup(List<String> newInterests, String groupID) {
        List<String> groupInterests = new ArrayList<>(groups.get(groupID).getInterests());
        for (String newInterest : newInterests) {
            boolean containsInterest = false;
            for (String existingInterest : groupInterests) {
                if (existingInterest.equals(newInterest)) {
                    containsInterest = true;
                    break;
                }
            }
            if (!containsInterest) {
                groupInterests.add(newInterest);
            }
        }
        groups.get(groupID).setInterests(groupInterests);
        this.save();
    }

    /**
     * Update the GroupDatabase by removing <interests> from the existing interests of the group with the ID,
     * <groupID>.
     *
     * @param interests list of interests to be removed from the group
     * @param groupID   group's ID
     */
    @Override
    public void removeInterestsFromGroup(List<String> interests, String groupID) {
        List<String> groupInterests = new ArrayList<>(groups.get(groupID).getInterests());
        for (String interestToBeRemoved : interests) {
            groupInterests.remove(interestToBeRemoved);
        }
        groups.get(groupID).setInterests(groupInterests);
        this.save();
    }

    /**
     * Get a list of group IDs matching all the random groups stored in the GroupDatabase.
     *
     * @return Returns a List of Strings where each String is the String representation of a random groups ID.
     */
    @Override
    public List<String> getRandomGroups() {
        List<String> randomGroupIDs = new ArrayList<>();
        for (GroupRepoRequestModel requestModel : groups.values()) {
            if (requestModel.isRandom()){
                randomGroupIDs.add(requestModel.getID());
            }
        }
        return randomGroupIDs;
    }

}
