package random_grouper_request_group.application_business_rules;

public interface ReqRanGroupOutputBoundary {
    /**
     * Format the successful result of requesting a random group.
     * @param group the response model created by the interactor
     * @return the formatted response model
     */
    ReqRanGroupResponseModel prepareSuccessView(ReqRanGroupResponseModel group);

    /**
     * Throws an error that contains an <errorMessage> that describes the error that occurred.
     * @param errorMessage a String describing the error that occurred.
     */
    ReqRanGroupResponseModel prepareFailView(String errorMessage);

    String getSuccessMessage (ReqRanGroupResponseModel group);
}
