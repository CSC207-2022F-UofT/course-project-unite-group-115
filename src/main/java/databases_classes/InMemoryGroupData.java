package databases_classes;

import databases_classes.GroupRepoInt;
import databases_classes.GroupRepoRequestModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryGroupData implements GroupRepoInt {
    final private Map<String, GroupRepoRequestModel> groups = new HashMap<>();

    /**
     * Add the group information from requestModel into the GroupDatabase file.
     *
     * @param requestModel information about group to save
     */
    @Override
    public void addGroup(GroupRepoRequestModel requestModel) {
        groups.put(requestModel.getID(), requestModel);
    }

    /**
     * Remove the group with ID, groupID, from the GroupDatabase file.
     *
     * @param groupID group's ID
     */
    @Override
    public void removeGroup(String groupID) {
        groups.remove(groupID);
    }

    /**
     * Return a map of information about the group with ID, groupID. Each key is a String indicating the
     * information provided by the key.
     * Each map contains the following keys and their associated values:
     * "group name" -> String of the group's name
     * "group ID" -> String form of group's ID
     * "members" -> List of Strings where each String is a members name
     * "interests" -> List of Strings where each String is one of the group's interests
     * "random group?" -> boolean value of whether group is a random group
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
    }

    /**
     * Update the GroupDatabase by removing User with name, <userName>, from the members of the group with the ID,
     * <groupID>.
     *
     * @param userName name of an existing User
     * @param groupID  group's ID
     */
    @Override
    public void removeUserFromGroup(String userName, String groupID) {
        List<String> members = new ArrayList<>(groups.get(groupID).getMembers());
        members.remove(userName);
        groups.get(groupID).setMembers(members);
    }

    /**
     * Update the GroupDatabase by adding interests, <newInterests>, to the existing interests of the group with the
     * ID, <groupID>.
     *
     * @param newInterests list of interests to be added to the group
     * @param groupID      group's ID
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
