package message_view;


import database_classes.MessageMemory;
import database_classes.MessageRepoInt;
import database_classes.MessageRepoRequestModel;
import message_view.interface_adaptor.ViewMessageFailure;

import org.junit.jupiter.api.Test;
import message_view.application_business_rule.ViewMessageInputBoundary;
import message_view.application_business_rule.ViewMessageInteractor;
import message_view.application_business_rule.ViewMessageRequestModel;
import message_view.application_business_rule.ViewMessageResponseModel;
import message_view.interface_adaptor.ViewMessagePresenter;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ViewMessageInteractorTest {


    @Test
    void create() {
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
    void createFail()  {
        MessageRepoInt message;
        message = new MessageMemory();

        ViewMessagePresenter presenter = new ViewMessagePresenter();

        ViewMessageInputBoundary interactor = new ViewMessageInteractor(
                message, presenter);


        ViewMessageRequestModel inputData2 = new ViewMessageRequestModel("group1", "paul");


        try {
            interactor.create(inputData2);
            fail("No one has sent a message in the group yet, sending your first message!");
        } catch (ViewMessageFailure e) {
        }
    }
}