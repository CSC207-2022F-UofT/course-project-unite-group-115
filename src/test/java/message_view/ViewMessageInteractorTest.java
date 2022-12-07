package message_view;

import database_classes.MessageDataAccess;
import database_classes.MessageRepoInt;
import org.junit.jupiter.api.Test;
import message_view.application_business_rule.ViewMessageInputBoundary;
import message_view.application_business_rule.ViewMessageInteractor;
import message_view.application_business_rule.ViewMessageRequestModel;
import message_view.application_business_rule.ViewMessageResponseModel;
import message_view.interface_adaptor.ViewMessagePresenter;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ViewMessageInteractorTest {

    @Test
    void create() throws IOException {
        MessageRepoInt message;
        message = new MessageDataAccess("./src/test/java/message_view/messagestestfile.csv");

        ViewMessagePresenter presenter = new ViewMessagePresenter() {
            @Override
            public ViewMessageResponseModel prepareSuccessView(ViewMessageResponseModel response) {
                // 4) Check that the Output Data and associated changes

                assertEquals(("[paul: hello Reactions: [[]] (Message ID:1)\n" +
                        "]").replace(","," "), response.getPresented());
                return null;

            }

            @Override
            public ViewMessageResponseModel prepareFailView(String error) {
                fail("No one has sent a message in the group yet, sending your first message!");
                return null;
            }
        };

        ViewMessageInputBoundary interactor = new ViewMessageInteractor(
                message, presenter);

        // 2) Input data — we can make this up for the test. Normally it would
        // be created by the Controller.
        ViewMessageRequestModel inputData = new ViewMessageRequestModel("group1", "paul");

        // 3) Run the use case
        interactor.create(inputData);
    }
}