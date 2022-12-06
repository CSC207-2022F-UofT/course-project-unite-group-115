package general_group.use_case;

public interface GeneralGroupCreateOutputBoundary {
    /**
     * Formats the information stored in the GeneralGroupCreateDsResponseModel
     * @param responseModel The GeneralGroupCreateDsResponseModel returned by the interactor
     * @return Formatted GeneralGroupCreateDsResponseModel
     */
    GeneralGroupCreateDsResponseModel prepareSuccessView(GeneralGroupCreateDsResponseModel responseModel);

    /**
     * Throws an error that contains an <errorMessage> that describes the error that occurred.
     * @param error a String describing the error that occurred.
     */
    GeneralGroupCreateDsResponseModel prepareFailView(String error);
}
