package Databases;

public interface ReactionRepoInt {

    void save (ReactionDsRequestModel requestModel);

    void deleteReaction(String messageID);
}
