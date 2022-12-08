package message_view.application_business_rule;

public interface ViewMessageOutputboundary {
    ViewMessageResponseModel prepareSuccessView(ViewMessageResponseModel response);

    ViewMessageResponseModel prepareFailView(String error);
}
