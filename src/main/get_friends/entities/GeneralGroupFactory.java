package get_friends.entities;

import java.util.List;

public class GeneralGroupFactory implements GroupFactory {

    @Override
    public Group createNewGroup(String name,List<String> interests, List<User> members) {
        return new Group(name, interests, members, false);
    }

    @Override
    public Group recreateExistingGroup(String name, List<String> interests, List<User> members, String id) {
        return new Group(name, interests, members, false, id);
    }
}
