package general_group.use_case;

public interface GeneralGroupCreateOutputBoundary {

    GeneralGroupCreateDsResponseModel prepareSuccessView(GeneralGroupCreateDsResponseModel group);

    GeneralGroupCreateDsResponseModel prepareFailView(String error);
}
