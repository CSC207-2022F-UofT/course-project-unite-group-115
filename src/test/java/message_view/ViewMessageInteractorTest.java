package message_view;

import database_classes.MessageDataAccess;
import database_classes.MessageMemory;
import database_classes.MessageRepoInt;
import database_classes.MessageRepoRequestModel;
import entities.MessageFactory;
import message_send.application_business_rule.MessageInputBoundary;
import message_send.application_business_rule.MessageInteractor;
import message_send.application_business_rule.MessageRequestModel;
import message_send.interface_adaptor.MessageCreationFailed;
import message_send.interface_adaptor.MessagePresenter;
import message_view.interface_adaptor.ViewMessageFailure;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import message_view.application_business_rule.ViewMessageInputBoundary;
import message_view.application_business_rule.ViewMessageInteractor;
import message_view.application_business_rule.ViewMessageRequestModel;
import message_view.application_business_rule.ViewMessageResponseModel;
import message_view.interface_adaptor.ViewMessagePresenter;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

class ViewMessageInteractorTest {


    @Test
    void create() throws IOException {
        MessageRepoInt message;
        message = new MessageMemory();

        ViewMessagePresenter presenter = new ViewMessagePresenter() {

            @Override
            public ViewMessageResponseModel prepareSuccessView(ViewMessageResponseModel response) {
                // 4) Check that the Output Data and associated changes

                assertEquals(("[paul: hello Reactions: [] (Message ID:1)\n" +
                        "]").replace(","," "), response.getPresented());
                return null;

            }

            @Override
            public ViewMessageResponseModel prepareFailView(String error) {
                fail("No one has sent a message in the group yet, sending your first message!");
                return null;
            }

        };
        List<String> emptyList = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        MessageRepoRequestModel inputData = new MessageRepoRequestModel(
                "hello", "paul", "group1", "1", emptyList, now);
        message.save(inputData);

        ViewMessageInputBoundary interactor = new ViewMessageInteractor(
                message, presenter);


        ViewMessageRequestModel inputData2 = new ViewMessageRequestModel("group1", "paul");


        interactor.create(inputData2);
    }


    @Test
    void createFail() throws IOException {
        MessageRepoInt message;
        message = new MessageMemory();

        ViewMessagePresenter presenter = new ViewMessagePresenter();
        List<String> emptyList = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
//        MessageRepoRequestModel inputData = new MessageRepoRequestModel(
//                "hello", "paul", "group1", "1", emptyList, now);
//        message.save(inputData);

        ViewMessageInputBoundary interactor = new ViewMessageInteractor(
                message, presenter);


        ViewMessageRequestModel inputData2 = new ViewMessageRequestModel("group1", "paul");


        try {
            interactor.create(inputData2);;
            fail("No one has sent a message in the group yet, sending your first message!");
        } catch (ViewMessageFailure e) {
        }
    }
}