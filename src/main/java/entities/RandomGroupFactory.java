package entities;

import java.util.List;

public class RandomGroupFactory implements GroupFactory {
    /**
     * Create and return a group object for a new random group.
     *
     * @param name the name of the group
     * @param interests the interests each group member must possess
     * @param members the members of the group
     * @return Returns a new group object
     */
    @Override
    public Group createNewGroup(String name, List<String> interests, List<User> members) {
        return new Group(name, interests, members, true);
    }

    /**
     * Create and return a new group object for an existing random group.
     *
     * @param name the name of the group
     * @param interests the interests each group member must possess
     * @param members the members of the group
     * @param id the group id
     * @return Returns a new group object
     */
    @Override
    public Group recreateExisitingGroup(String name, List<String> interests, List<User> members, String id) {
        return new Group(name, interests, members, true, id);
    }
}
