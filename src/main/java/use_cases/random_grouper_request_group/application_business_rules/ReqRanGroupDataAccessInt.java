package use_cases.random_grouper_request_group.application_business_rules;

import java.util.List;
import java.util.Map;

public interface ReqRanGroupDataAccessInt {
    /**
     * Get a list of group IDs matching all the random groups stored in the GroupDatabase.
     *
     * @return Returns a List of Strings where each String is the String representation of a random groups ID.
     */
    List<String> getRandomGroups();

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
}
