package general_group.use_case;

public interface GeneralGroupCreateOutputBoundary {

    GeneralGroupCreateDsResponseModel prepareSuccessView(GeneralGroupCreateDsResponseModel responseModel);

    GeneralGroupCreateDsResponseModel prepareFailView(String error);
}
