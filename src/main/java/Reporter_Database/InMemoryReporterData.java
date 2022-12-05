package Reporter_Database;

import java.util.HashMap;
import java.util.Map;

public class InMemoryReporterData implements GroupRepoInt{
    private final Map<String, RepoMessageModel> accounts = new HashMap<>();

    @Override
    public void adduserModel(RepoMessageModel userMessageModel){
        System.out.println("Save " + userMessageModel.getMessageId());
        accounts.put(userMessageModel.getMessageId(), userMessageModel);
    }
}
