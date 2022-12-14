package entities;

import java.util.List;

public interface GroupFactory {
    /**
     * Create and return a group object for a new group.
     *
     * @param name the name of the group
     * @param interests the interests each group member must possess
     * @param members the names of the members of the group
     * @return Returns a new group object
     */
    Group createNewGroup(String name, List<String> interests, List<String> members);

    /**
     * Create and return a new group object for an existing group.
     *
     * @param name the name of the group
     * @param interests the interests each group member must possess
     * @param members the names of the members of the group
     * @param id the group id
     * @return Returns a new group object
     */
    Group recreateExistingGroup(String name, List<String> interests, List<String> members, String id);
}
