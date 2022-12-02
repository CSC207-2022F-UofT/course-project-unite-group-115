package databases_message;

import java.util.List;
import java.util.Map;

public interface MessageRepoInt {

    void save(MessageDsRequestModel requestModel);

    void deleteMessage(String ID);

    Map<String, Object> getMessageInfo(String messageID);

    void editMessage(String ID, String content);

    List<String> getGroupMessageInfo(String GroupID);

}
