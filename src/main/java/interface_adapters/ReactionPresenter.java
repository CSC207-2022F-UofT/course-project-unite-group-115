package interface_adapters;

import reaction_use_case.ReactionOutputBoundary;
import reaction_use_case.ReactionResponseModel;

/**
 * The ReactionPresenter implements interface ReactionOutputBoundary that
 * contains the methods on what to display upon a successful action and what to display
 * upon a fail action.
 *
 * @author  Hansel Jia
 */
public class ReactionPresenter implements ReactionOutputBoundary {

    /**
     * This method is used to display that a reaction add or remove was successful
     * @param response This parameter is of the ReactionResponseModel data structure
     *                 which holds information on the reaction type and the messageID
     *                 associated with the reaction.
     */
    @Override
    public ReactionResponseModel prepareSuccessView(ReactionResponseModel response){
        return response;
    }

    /**
     * This method is used to display that a reaction add or remove was not successful
     * @param error This parameter contains the error message displaying why the add/remove
     *              could not be passed through the database.
     */
    @Override
    public ReactionResponseModel prepareFailView(String error){
        throw new ReactionActionFailed(error);
    }

}
