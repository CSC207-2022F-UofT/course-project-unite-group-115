package messgae_use_case;

public interface ViewMessageOutputboundary {
    ViewMessageResponseModel prepareSuccessView(ViewMessageResponseModel response);

    ViewMessageResponseModel prepareFailView(String error);
}
