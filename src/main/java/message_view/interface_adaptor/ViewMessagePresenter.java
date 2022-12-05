package message_view.interface_adaptor;

import message_view.application_business_rule.ViewMessageOutputboundary;
import message_view.application_business_rule.ViewMessageResponseModel;

public class ViewMessagePresenter implements ViewMessageOutputboundary {

    @Override
    public ViewMessageResponseModel prepareSuccessView(ViewMessageResponseModel response) {
        return response;
    }

    public ViewMessageResponseModel prepareFailView(String error) {
        return null;
    }

}
