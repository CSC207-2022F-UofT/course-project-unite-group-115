package reaction_use_case;

/**
 * The ReactionOutputBoundary is an interface implemented by the presenter.
 *
 * @author  Hansel Jia
 */
public interface ReactionOutputBoundary {

    /**
     * This method is used to display that a reaction add or remove was successful
     * @param response This parameter is of the ReactionResponseModel data structure
     *                 which holds information on the reaction type and the messageID
     *                 associated with the reaction.
     */
    ReactionResponseModel prepareSuccessView(ReactionResponseModel response);

    /**
     * This method is used to display that a reaction add or remove was not successful
     * @param error This parameter contains the error message displaying why the add/remove
     *              could not be passed through the database.
     */
    ReactionResponseModel prepareFailView(String error);

}
