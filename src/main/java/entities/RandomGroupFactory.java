package entities;

import java.util.List;

public class RandomGroupFactory implements GroupFactory {

    @Override
    public Group createNewGroup(String name, List<String> interests, List<User> members) {
        return new Group(name, interests, members, true);
    }

    @Override
    public Group recreateExisitingGroup(String name, List<String> interests, List<User> members, String id) {
        return new Group(name, interests, members, true, id);
    }
}
