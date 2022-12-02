package interface_adapters;

import messgae_use_case.MessageResponseModel;
import messgae_use_case.ViewMessageOutputboundary;
import messgae_use_case.ViewMessageResponseModel;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ViewMessagePresenter implements ViewMessageOutputboundary {

    @Override
    public ViewMessageResponseModel prepareSuccessView(ViewMessageResponseModel response) {
        return response;
    }

    //TODO: add fail review, i.e. sender is in the banned list
    public ViewMessageResponseModel prepareFailView(String error){
        throw new MessageCreationFailed(error);
    }
}
