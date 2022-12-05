package database_classes;

import java.util.Map;

//DsGateway
public interface MessageRepoInt{

    void save(MessageRepoRequestModel requestModel);

    void deleteMessage(String ID);

    Map<String, Object> getMessageInfo(String messageID);

    void editMessage(String ID, String content);

    String getGroupMessageInfo(String GroupID);

}
