package random_grouper.frameworks_and_drivers;

import random_grouper.application_business_rules.GroupRepoInt;
import random_grouper.application_business_rules.GroupRepoRequestModel;

import java.io.*;
import java.util.*;

public class GroupDataAccess implements GroupRepoInt {
    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, GroupRepoRequestModel> groups = new HashMap<>();

    public GroupDataAccess(String csvFilePath) throws IOException {
        csvFile = new File(csvFilePath);

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
     * Add the group information from requestModel in the GroupRepo
     *
     * @param requestModel information about group to save
     */
    @Override
    public void addGroup(GroupRepoRequestModel requestModel){
        groups.put(requestModel.getID(), requestModel);
        this.save();
    }

    /**
     * Remove the group with ID, groupID, from the group repo.
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
     * Each map contains the keys "group name", "group ID", "members", "interests" and "random group?" associated
     * with their appropriate values.
     *
     * @param groupID the ID of a group
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
     * Add User with name, userName, to the members of the group with the ID, groupID.
     *
     * @param userName name of an existing User
     * @param groupID  group's ID
     */
    @Override
    public void addUserToGroup(String userName, String groupID) {
        List<String> members = groups.get(groupID).getMembers();
        members.add(userName);
        groups.get(groupID).setMembers(members);
        this.save();
    }

    /**
     * Remove User with name, userName, from the members of the group with the ID, groupID.
     *
     * @param userName name of an existing User
     * @param groupID  group's ID
     */
    @Override
    public void removeUserFromGroup(String userName, String groupID) {
        List<String> members = groups.get(groupID).getMembers();
        members.remove(userName);
        groups.get(groupID).setMembers(members);
        this.save();
    }

    /**
     * Add interests to the existing interests of the group with the ID, groupID.
     *
     * @param newInterests list of interests to be added to the group
     * @param groupID   group's ID
     */
    @Override
    public void addInterestsToGroup(List<String> newInterests, String groupID) {
        List<String> groupInterests = groups.get(groupID).getInterests();
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
     * Remove interests from the existing interests of the group with the ID, groupID.
     *
     * @param interests list of interests to be removed from the group
     * @param groupID   group's ID
     */
    @Override
    public void removeInterestsFromGroup(List<String> interests, String groupID) {
        List<String> groupInterests = groups.get(groupID).getInterests();
        for (String interestToBeRemoved : interests) {
            groupInterests.remove(interestToBeRemoved);
        }
        groups.get(groupID).setInterests(groupInterests);
        this.save();
    }

    /**
     * Return a list of the group IDs of all the random groups.
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
