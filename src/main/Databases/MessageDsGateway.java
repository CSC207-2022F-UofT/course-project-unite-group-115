package Databases;
import entities.Message;
import reaction_use_case.ReactionCreateDsRequestModel;

public interface MessageDsGateway {
    Message getMessage(int messageID);

    void storeMessage(Message message);

    void deleteMessage(int messageID);

    Boolean reactionExists(int messageID);

    void addReaction(ReactionCreateDsRequestModel reactionDsModel);
    void removeReaction(int messageID);

}
