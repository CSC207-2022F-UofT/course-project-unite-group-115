package databases;

import java.util.List;
import java.util.Map;

public interface MessageRepoInt {
    void save(MessageDsRequestModel requestModel);

    void deleteMessage(String ID);

    Map<String, Object> getMessageInfo(String messageID);

    void editMessage(String ID, String content);

    List<String> getGroupMessageInfo(String GroupID);

    boolean messageNotExist(String messageID);

    void addReaction(String reaction, String messageID);

    void removeReaction(String reaction, String messageID);

    boolean reactionExists(String reaction, String messageID);
}