package entities;

import java.util.List;

public class GeneralGroupFactory implements GroupFactory {
    /**
     * Creates a new GeneralGroup and returns it
     * @param name the name of the group
     * @param interests the interests each group member must possess
     * @param members the members of the group
     * @return a new GeneralGroup
     */
    @Override
    public Group createNewGroup(String name, List<String> interests, List<String> members) {
        return new Group(name, interests, members, false);
    }


    /**
     * Recreates a new GeneralGroup that was created before
     * @param name the name of the group
     * @param interests the interests each group member must possess
     * @param members the members of the group
     * @param id the group id
     * @return a previously made GeneralGroup
     */
    @Override
    public Group recreateExistingGroup(String name, List<String> interests, List<String> members, String id) {
        return new Group(name, interests, members, false, id);
    }
}
