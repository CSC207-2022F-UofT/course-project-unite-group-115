package message_send;

import database_classes.MessageMemory;
import database_classes.MessageRepoInt;
import entities.MessageFactory;
import use_cases.message_send.application_business_rule.MessageInputBoundary;
import use_cases.message_send.application_business_rule.MessageInteractor;
import use_cases.message_send.application_business_rule.MessageRequestModel;
import use_cases.message_send.application_business_rule.MessageResponseModel;
import use_cases.message_send.interface_adaptor.MessagePresenter;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class MessageInteractorTest {

    @Test
    public void create() {

        MessageRepoInt message = new MessageMemory();


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

        // 2) Input data we can make this up for the test. Normally it would
        // be created by the Controller.
        MessageRequestModel inputData = new MessageRequestModel(
                "paul", "pwd1234", "1");

        // 3) Run the use case
        interactor.create(inputData);


    }

    @Test
    public void createfail() {

        MessageRepoInt message = new MessageMemory();

        MessagePresenter presenter = new MessagePresenter() {

            @Override
            public MessageResponseModel prepareSuccessView(MessageResponseModel response) {
                // 4) Check that the Output Data and associated changes

                fail("use case failed unexpected");
                return null;

            }

            @Override
            public MessageResponseModel prepareFailView(String error) {
                assertEquals("Message content can not be empty or only one letter.", error);
                return null;
            }
        };

        MessageFactory MessageFactory = new MessageFactory();
        MessageInputBoundary interactor = new MessageInteractor(
                message, presenter, MessageFactory);

        MessageRequestModel inputData = new MessageRequestModel(
                "", "paul", "pwd12345");

        interactor.create(inputData);

    }





}