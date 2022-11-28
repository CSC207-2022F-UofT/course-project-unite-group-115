package general_group.use_case;

import database_classes.GroupRepoDsRequestModel;
import java.util.Map;
import java.util.List;

public interface GroupRepoInt {

    void addGroup(GroupRepoDsRequestModel requestModel);

    void removeGroup(String groupID);

    Map<String, Object> getGroupData(String groupID);

    void addUserToGroup(String user, String groupID);

    void removeUserFromGroup(String user, String groupID);

    void addInterestsToGroup(String interest, String groupID);

    void removeInterestsfromGroup(String interest, String groupID);

    List<String> getGroups();



}
