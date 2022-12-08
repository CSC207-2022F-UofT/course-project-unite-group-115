package database_classes;

import java.util.Map;

//DsGateway
public interface MessageRepoInt{

    void save(MessageRepoRequestModel requestModel);

    void deleteMessage(String ID);

    Map<String, Object> getMessageInfo(String messageID);

    void editMessage(String ID, String content);

    String getGroupMessageInfo(String GroupID);


    boolean doesGroupExist(String GroupID);

    boolean messageNotExist(String messageID);

    void addReaction(String reaction, String messageID);

    void removeReaction(String reaction, String messageID);

    boolean reactionExists(String reaction, String messageID);

}
