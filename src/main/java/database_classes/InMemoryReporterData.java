package database_classes;

import database_classes.UserReporterInt;
import database_classes.UserReporterRepoRequestModel;

import java.util.HashMap;
import java.util.Map;

public class InMemoryReporterData implements UserReporterInt {
    private final Map<String, UserReporterRepoRequestModel> accounts = new HashMap<>();

    @Override
    public void adduserModel(UserReporterRepoRequestModel userMessageModel){
        System.out.println("Save " + userMessageModel.getMessageId());
        accounts.put(userMessageModel.getMessageId(), userMessageModel);
    }
}
