package random_grouper_create.application_business_rules;

public interface RanGroupCreateOutputBoundary {
    /**
     * Formats the information stored in the RanGroupCreateResponseModel data structure.
     * @param response the RanGroupCreateResponseModel returned by the interactor
     * @return returns a formatted RanGroupCreateResponseModel
     */
    RanGroupCreateResponseModel prepareSuccessView(RanGroupCreateResponseModel response);

    RanGroupCreateResponseModel prepareFailView(String errorMessage);
}
