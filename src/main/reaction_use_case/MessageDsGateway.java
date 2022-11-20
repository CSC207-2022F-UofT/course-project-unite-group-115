package reaction_use_case;

import entities.Message;

public interface MessageDsGateway {
//    Message getMessage(int messageID);
//
    void storeMessage(MessageDsRequestModel requestModel);

//    void deleteMessage(int messageID);

    void addReaction(ReactionDsRequestModel reactionDsModel);
    void removeReaction(ReactionDsRequestModel reactionDsModel);

}
