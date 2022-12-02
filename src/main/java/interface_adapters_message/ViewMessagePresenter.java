package interface_adapters_message;

import use_case_message_view.ViewMessageOutputboundary;
import use_case_message_view.ViewMessageResponseModel;

public class ViewMessagePresenter implements ViewMessageOutputboundary {

    @Override
    public ViewMessageResponseModel prepareSuccessView(ViewMessageResponseModel response) {
        return response;
    }

    //TODO: add fail review, i.e. sender is in the banned list
    public ViewMessageResponseModel prepareFailView(String error) {
        return null;
    }

}
