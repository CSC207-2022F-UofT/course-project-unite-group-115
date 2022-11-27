package reaction_use_case;

import Databases.ReactionDsRequestModel;

public interface ReactionDsGateway {

    void save(ReactionDsRequestModel requestModel);
    void addReaction(ReactionDsRequestModel requestModel);

    void removeReaction(String messageID);

}
