package use_case_message_view;

public interface ViewMessageOutputboundary {
    ViewMessageResponseModel prepareSuccessView(ViewMessageResponseModel response);

    ViewMessageResponseModel prepareFailView(String error);
}
