package general_group.use_case;

import database_classes.GroupRepoRequestModel;

import java.util.List;
import java.util.Map;

public interface GroupRepoInt {
    /**
     * Adds the group information from the requestModel into the group file
     * @param requestModel Information about the group
     */
    void addGroup(GroupRepoRequestModel requestModel);

    /**
     * Removes the group with the groupID from the group file
     * @param groupID The ID specific to the group
     */
    void removeGroup(String groupID);

    /**
     * Gets the info of the group using the groupID
     * @param groupID The ID specific to the group.
     * @return The object corresponding to the groupID
     */
    Map<String, Object> getGroupInfo(String groupID);

    /**
     * Adds the userName into the group with the corresponding groupID
     * @param userName The userName that is to be added
     * @param groupID The ID specific to the group
     */
    void addUserToGroup(String userName, String groupID);

    /**
     * Removes the userName from the group with the corresponding groupID
     * @param userName The userName that is to be removed
     * @param groupID The ID specific to the group
     */
    void removeUserFromGroup(String userName, String groupID);

    void addInterestsToGroup(List<String> newInterests, String groupID);

    void removeInterestsFromGroup(List<String> interests, String groupID);

    List<String> getRandomGroups();
}
