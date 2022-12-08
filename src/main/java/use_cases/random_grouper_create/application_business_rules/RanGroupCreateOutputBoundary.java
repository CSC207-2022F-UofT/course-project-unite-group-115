package use_cases.random_grouper_create.application_business_rules;

public interface RanGroupCreateOutputBoundary {
    /**
     * Formats the information stored in the RanGroupCreateResponseModel data structure.
     * @param response the RanGroupCreateResponseModel returned by the interactor
     * @return returns a formatted RanGroupCreateResponseModel
     */
    RanGroupCreateResponseModel prepareSuccessView(RanGroupCreateResponseModel response);

    /**
     * Throws an error that contains an <errorMessage> that describes the error that occurred.
     * @param errorMessage a String describing the error that occurred.
     */
    RanGroupCreateResponseModel prepareFailView(String errorMessage);
}
