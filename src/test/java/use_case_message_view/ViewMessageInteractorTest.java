package use_case_message_view;

import databases_message.MessageFile;
import databases_message.MessageRepoInt;
import entity_message.MessageFactory;
import interface_adapters_message.MessagePresenter;
import interface_adapters_message.ViewMessagePresenter;
import org.junit.jupiter.api.Test;
import use_case_message_send.MessageInputBoundary;
import use_case_message_send.MessageInteractor;
import use_case_message_send.MessageRequestModel;
import use_case_message_send.MessageResponseModel;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ViewMessageInteractorTest {

    @Test
    void create() throws IOException {
        MessageRepoInt message;
        message = new MessageFile("./src/main/java/databases_message/messagestestfile.csv");

        // This creates an anonymous implementing class for the Output Boundary.
        ViewMessagePresenter presenter = new ViewMessagePresenter() {
            @Override
            public ViewMessageResponseModel prepareSuccessView(ViewMessageResponseModel response) {
                // 4) Check that the Output Data and associated changes

                assertEquals("[paul: hello (1)Reactions: [[]]]", response.getPresented());
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