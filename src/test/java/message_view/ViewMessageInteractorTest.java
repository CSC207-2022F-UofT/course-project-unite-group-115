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
        message = new MessageDataAccess("./src/main/java/database_classes/messagestestfile.csv");

        // This creates an anonymous implementing class for the Output Boundary.
        ViewMessagePresenter presenter = new ViewMessagePresenter() {
            @Override
            public ViewMessageResponseModel prepareSuccessView(ViewMessageResponseModel response) {
                // 4) Check that the Output Data and associated changes

                assertEquals(("[paul: hello (1)Reactions: [[]]\n" +
                        "]").replace(","," "), response.getPresented());
                return null;
            }

            @Override
            public ViewMessageResponseModel prepareFailView(String error) {
                fail("No one chat in the group, send your first message!");
                return null;
            }
        };

        ViewMessageInputBoundary interactor = new ViewMessageInteractor(
                message, presenter);

        // 2) Input data — we can make this up for the test. Normally it would
        // be created by the Controller.
        ViewMessageRequestModel inputData = new ViewMessageRequestModel("group1");

        // 3) Run the use case
        interactor.create(inputData);
    }
}