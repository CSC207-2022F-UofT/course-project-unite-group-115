package databases_classes;

import java.util.List;
import java.util.Map;

public interface GroupRepoInt {
    /**
     * Add the group information from requestModel into the GroupDatabase file.
     *
     * @param requestModel information about group to save
     */
    void addGroup(GroupRepoRequestModel requestModel);

    /**
     * Remove the group with ID, groupID, from the GroupDatabase file.
     *
     * @param groupID group's ID
     */
    void removeGroup(String groupID);

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
    Map<String, Object> getGroupInfo(String groupID);

    /**
     * Update the GroupDatabase by adding User with name, <userName>, to the members of the group with the ID,
     * <groupID>.
     *
     * @param userName name of an existing User
     * @param groupID  group's ID
     */
    void addUserToGroup(String userName, String groupID);

    /**
     * Update the GroupDatabase by removing User with name, <userName>, from the members of the group with the ID,
     * <groupID>.
     *
     * @param userName name of an existing User
     * @param groupID  group's ID
     */
    void removeUserFromGroup(String userName, String groupID);

    /**
     * Update the GroupDatabase by adding interests, <newInterests>, to the existing interests of the group with the
     * ID, <groupID>.
     *
     * @param newInterests list of interests to be added to the group
     * @param groupID   group's ID
     */
    void addInterestsToGroup(List<String> newInterests, String groupID);

    /**
     * Update the GroupDatabase by removing <interests> from the existing interests of the group with the ID,
     * <groupID>.
     *
     * @param interests list of interests to be removed from the group
     * @param groupID   group's ID
     */
    void removeInterestsFromGroup(List<String> interests, String groupID);

    /**
     * Get a list of group IDs matching all the random groups stored in the GroupDatabase.
     *
     * @return Returns a List of Strings where each String is the String representation of a random groups ID.
     */
    List<String> getRandomGroups();

}
