package reaction_use_case;

import databases.MessageFile;
import databases.MessageRepoInt;
import entities.ReactionFactory;
import org.junit.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class ReactionInteractorTest {

    @Test
    public void addReaction() {
        MessageRepoInt messageRepoInt;
        try {
            messageRepoInt = new MessageFile("./messages.csv");
        } catch (IOException e){
            throw new RuntimeException("Could not create file");
        }

        ReactionOutputBoundary presenter = new ReactionOutputBoundary() {
            @Override
            public ReactionResponseModel prepareSuccessView(ReactionResponseModel reaction) {
                // 4) Check that the Output Data and associated changes
                // are correct
                assertEquals("heart", reaction.getReaction());
                assertEquals("123", reaction.getMessageID());
                assertTrue(messageRepoInt.reactionExists("heart", "123"));
                return null;
            }

            @Override
            public ReactionResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        ReactionFactory reactionFactory = new ReactionFactory();
        ReactionInputBoundary interactor = new ReactionInteractor(
                messageRepoInt, presenter, reactionFactory);

        // 2) Input data — we can make this up for the test. Normally it would
        // be created by the Controller.
        ReactionRequestModel inputData = new ReactionRequestModel(
                "heart", "123");

        // 3) Run the use case
        interactor.createReaction(inputData);

    }
}
