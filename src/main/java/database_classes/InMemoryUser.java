package database_classes;



import java.util.HashMap;
import java.util.Map;
public class InMemoryUser implements UserRepoInt{
    final private Map<String, UserRepoRequestModel> users = new HashMap<>();

    /**
     * @param identifier the user's username
     * @return whether the user exists
     */
    @Override
    public boolean existsByName(String identifier) {
        return users.containsKey(identifier);
    }

    /**
     * @param requestModel the data to save
     */
    @Override
    public void save(UserRepoRequestModel requestModel) {
        System.out.println("Save " + requestModel.getName());
        users.put(requestModel.getName(), requestModel);
    }
}
