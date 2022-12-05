package message_send;

import database_classes.MessageDataAccess;
import database_classes.MessageRepoInt;
import enties.MessageFactory;
import org.junit.jupiter.api.Test;
import message_send.application_business_rule.MessageInputBoundary;
import message_send.application_business_rule.MessageInteractor;
import message_send.application_business_rule.MessageRequestModel;
import message_send.application_business_rule.MessageResponseModel;
import message_send.interface_adaptor.MessagePresenter;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MessageInteractorTest {

    @Test
    public void create() throws IOException {
        // To test the use case:
        // 1) Create a MessageInteractor and prerequisite objects
        //    (arguments for the MessageInteractor constructor parameters)
        // 2) create the Input Data
        // 3) Call the use case Message Input Boundary method to run the use case
        // 4) Check that the Output Data passed to the Presenter is correct
        // 5) Check that the expected changes to the data layer are there.

        // 1) MessageInteractor and prerequisite objects
        // We're going to need a place to save and look up information. We could
        // use FileMessage, but because unit tests are supposed to be independent
        // that would make us also reset the file when we are done.
        // Instead, we're going to "mock" that info using a short-lived solution
        // that just keeps the info in a dictionary, and it won't be persistent.
        // (Separately, elsewhere, we will need to test the FileMessage works
        // properly.)

        MessageRepoInt message;
        message = new MessageDataAccess("./src/main/java/database_classes/messagestestfile.csv");

        // This creates an anonymous implementing class for the Output Boundary.
        MessagePresenter presenter = new MessagePresenter() {
            @Override
            public MessageResponseModel prepareSuccessView(MessageResponseModel response) {
                // 4) Check that the Output Data and associated changes
                // are correct
                assertEquals("pwd1234", response.getSend());
                assertNotNull(response.getCreationTime());
                return null;
            }

            @Override
            public MessageResponseModel prepareFailView(String error) {
                fail("Message content can not be empty.");
                return null;
            }
        };

        MessageFactory MessageFactory = new MessageFactory();
        MessageInputBoundary interactor = new MessageInteractor(
                message, presenter, MessageFactory);

        // 2) Input data — we can make this up for the test. Normally it would
        // be created by the Controller.
        MessageRequestModel inputData = new MessageRequestModel(
                "paul", "pwd1234", "pwd12345");

        // 3) Run the use case
        interactor.create(inputData);


    }
}