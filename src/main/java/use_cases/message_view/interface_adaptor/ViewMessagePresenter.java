package use_cases.message_view.interface_adaptor;

import use_cases.message_view.application_business_rule.ViewMessageOutputboundary;
import use_cases.message_view.application_business_rule.ViewMessageResponseModel;

public class ViewMessagePresenter implements ViewMessageOutputboundary {

    @Override
    public ViewMessageResponseModel prepareSuccessView(ViewMessageResponseModel response) {
        return response;
    }

    public ViewMessageResponseModel prepareFailView(String error) {throw new ViewMessageFailure(error);}

}
