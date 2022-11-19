package interface_adapters;

import MessageUserCase.MessageResponseModel;

public interface MessagePresenter {
    MessageResponseModel prepareSuccessView(MessageResponseModel user);

    MessageResponseModel prepareFailView(String error);
}
