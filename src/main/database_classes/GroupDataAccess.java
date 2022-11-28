package database_classes;

import general_group.use_case.GroupRepoInt;

import java.util.List;
import java.util.Map;

public class GroupDataAccess implements GroupRepoInt {

    @Override
    public void addGroup(GroupRepoDsRequestModel requestModel) {

    }

    @Override
    public void removeGroup(String groupID) {

    }

    @Override
    public Map<String, Object> getGroupData(String groupID) {
        return null;
    }

    @Override
    public void addUserToGroup(String user, String groupID) {

    }

    @Override
    public void removeUserFromGroup(String user, String groupID) {

    }

    @Override
    public void addInterestsToGroup(String interest, String groupID) {

    }

    @Override
    public void removeInterestsfromGroup(String interest, String groupID) {

    }

    @Override
    public List<String> getGroups() {
        return null;
    }
}
