package MessageUserCase;

public interface EditMessageOutputBoundary {
    EditMessageResponseModel prepareSuccessView(EditMessageResponseModel ??);

    EditMessageResponseModel prepareFailView(String error);
}