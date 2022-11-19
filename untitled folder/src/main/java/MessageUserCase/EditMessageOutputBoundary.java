package MessageUserCase;

public interface EditMessageOutputBoundary {
    EditMessageResponseModel prepareSuccessView(EditMessageResponseModel response);

    EditMessageResponseModel prepareFailView(String error);
}