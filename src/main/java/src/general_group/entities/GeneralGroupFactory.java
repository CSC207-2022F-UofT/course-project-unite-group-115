package general_group.entities;

import java.util.List;

public class GeneralGroupFactory implements GroupFactory {

    @Override
    public Group createNewGroup(String name,List<String> interests, List<String> members) {
        return new Group(name, interests, members, false);
    }

    @Override
    public Group recreateExistingGroup(String name, List<String> interests, List<String> members, String id) {
        return new Group(name, interests, members, false, id);
    }
}
