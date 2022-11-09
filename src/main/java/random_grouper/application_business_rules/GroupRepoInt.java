package random_grouper.application_business_rules;

import java.util.List;
import java.util.Map;

public interface GroupRepoInt {
    /**
     * Add the group information from requestModel in the GroupRepo
     *
     * @param requestModel information about group to save
     */
    void addGroup(GroupRepoRequestModel requestModel);

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
    void addInterestsToGroup(List<String> newInterests, String groupID);

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
