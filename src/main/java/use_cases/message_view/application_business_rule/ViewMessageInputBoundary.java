package use_cases.message_view.application_business_rule;

public interface ViewMessageInputBoundary {
    ViewMessageResponseModel create(ViewMessageRequestModel requestModel);
}
