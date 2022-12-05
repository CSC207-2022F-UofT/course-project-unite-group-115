package general_group.use_case;

import database_classes.GroupRepoDsRequestModel;
import java.util.Map;

public interface GroupRepoInt {

    void addGroup(GroupRepoDsRequestModel requestModel);

    void removeGroup(String groupID);

    Map<String, Object> getGroupInfo(String groupID);

    void addUserToGroup(String userName, String groupID);

    void removeUserFromGroup(String userName, String groupID);

}
