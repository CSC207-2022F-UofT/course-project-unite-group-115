package general_group.use_case;

public interface GeneralGroupOutputBoundary {

    GeneralGroupCreateDsResponseModel prepareSuccessView(GeneralGroupCreateDsResponseModel group);

    GeneralGroupCreateDsResponseModel prepareFailView(String error);
}
