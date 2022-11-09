package random_grouper.application_business_rules;

import java.util.List;
import java.util.Map;

public interface GroupRepoInt {
    /**
     * Add a group to the group repo.
     *
     * @param groupName group's name
     * @param groupID group's ID
     * @param groupMembers group's members
     * @param groupInterests group's interests
     * @param isRandom whether the group is a random group
     */
    void addGroup(String groupName, String groupID, List<String> groupMembers, List<String> groupInterests,
                  boolean isRandom);

    /**
     * Remove the group with ID, groupID, from the group repo.
     *
     * @param groupID group's ID
     */
    void removeGroup(String groupID);

    /**
     * Return a map of information about the group with ID, groupID. Each key is a String indicating the
     * information provided by the key.
     * Each map contains the group's name, ID, members, interests and whether it is a random group.
     *
     * @param groupID the ID of a group
     */
    Map<String, Object> getGroupInfo(String groupID);

    /**
     * Add User with name, userName, to the members of the group with the ID, groupID.
     *
     * @param userName name of an existing User
     * @param groupID group's ID
     */
    void addUserToGroup(String userName, String groupID);

    /**
     * Remove User with name, userName, from the members of the group with the ID, groupID.
     *
     * @param userName name of an existing User
     * @param groupID group's ID
     */
    void removeUserFromGroup(String userName, String groupID);

    /**
     * Add interests to the existing interests of the group with the ID, groupID.
     *
     * @param interests list of interests to be added to the group
     * @param groupID group's ID
     */
    void addInterestsToGroup(List<String> interests, String groupID);

    /**
     * Remove interests from the existing interests of the group with the ID, groupID.
     *
     * @param interests list of interests to be removed from the group
     * @param groupID group's ID
     */
    void removeInterestsFromGroup(List<String> interests, String groupID);

    /**
     * Return a list of the group IDs of all the random groups.
     */
    List<String> getRandomGroups();

}
