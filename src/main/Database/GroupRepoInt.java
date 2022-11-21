package Database;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface GroupRepoInt {

    //void save(UserMessageModel userMessageModel);

    /*
         add blacklist users to database
         */
    void adduserModel(UserMessageModel userMessageModel);

  // update banned message
    void removeUserModel(String userModelID);

   // get message of users
    Map<String, Object> getUserInfo(String userID);




    /**
     * Get a list of group IDs matching all the random groups stored in the GroupDatabase.
     *
     * @return Returns a List of Strings where each String is the String representation of a random groups ID.
     */
    // get message of users
    HashMap<String,Object> getMessageList(String userId, String message);

}
