package Reporter_Database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Profile_Data implements ProfileRepoInt{
    private final Map<String, ProfileRepoRequestModel> accounts = new HashMap<>();


    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public void save(ProfileRepoRequestModel requestModel) {
        System.out.println("Save " + requestModel.getUserName());
        accounts.put(requestModel.getUserName(), requestModel);
    }

    @Override
    public void addBlockedUserToProfile(String userName, String blockuer) {
        String blockList = accounts.get(userName).getBlockedUsers();
        String newBlocked ="[";
        blockList = newBlocked +blockList +";"+blockuer+"]";
        accounts.get(userName).setBlockedUsers(blockList);
    }

    @Override
    public List<String> getSensitiveWords(String userName) {
        return accounts.get(userName).getSensitiveWords();
    }

    @Override
    public String getBlockedUser(String userName) {
        return accounts.get(userName).getBlockedUsers();
    }


}