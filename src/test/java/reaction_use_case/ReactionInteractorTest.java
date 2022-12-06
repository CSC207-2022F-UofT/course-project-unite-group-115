package reaction_use_case;

import database_classes.MessageMemory;
import database_classes.MessageRepoInt;
import database_classes.MessageRepoRequestModel;
import org.junit.Test;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * This class tests standard and edge cases of the methods addReaction and removeReaction
 * in the Reaction Interactor. As unit tests are supposed to be independent every test relies
 * on the MessageMemory database which contains the same methods implemented in near identical ways
 * @author  Hansel Jia
 */
public class ReactionInteractorTest {
    /**
     * Standard add reaction test where a message is added manually, and it is checked whether
     * a reaction can be added to the message in the database successfully.
     */
    @Test
    public void addReaction() {

        // 1) Create prerequisite objects
        MessageRepoInt messageRepoInt = new MessageMemory();

        // Test reactions by adding a message manually
        List<String> emptyList = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        MessageRepoRequestModel request = new MessageRepoRequestModel("hello","Michael","14",
                "123", emptyList, now);
        messageRepoInt.save(request);

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

        // 1) Create interactor
        ReactionInputBoundary interactor = new ReactionInteractor(
                messageRepoInt, presenter);

        // 2) Input data
        ReactionRequestModel inputData = new ReactionRequestModel(
                "heart", "123");

        // 3) Run the use case
        interactor.addReaction(inputData);

    }

    /**
     * Edge case where the test attempts to add a reaction to a message which
     * already has the same reaction on it. An error containing the message that
     * the reaction already exists should be returned.
     */
    @Test
    public void addReactionWhenExists() {
        // 1) Create prerequisite objects
        MessageRepoInt messageRepoInt = new MessageMemory();

        // Test reactions by adding a message manually
        List<String> list = new ArrayList<>();
        list.add("heart");
        LocalDateTime now = LocalDateTime.now();
        MessageRepoRequestModel request = new MessageRepoRequestModel("hello","Michael","14",
                "123", list, now);
        messageRepoInt.save(request);

        ReactionOutputBoundary presenter = new ReactionOutputBoundary() {
            @Override
            public ReactionResponseModel prepareSuccessView(ReactionResponseModel reaction) {
                fail("Use case failure is unexpected.");
                return null;
            }

            @Override
            public ReactionResponseModel prepareFailView(String error) {
                // 4) Check that the Output Data and associated changes
                // are correct
                assertEquals("Reaction already exists on message: 123", error);
                return null;
            }
        };

        // 1) Create interactor
        ReactionInputBoundary interactor = new ReactionInteractor(
                messageRepoInt, presenter);

        // 2) Input data
        ReactionRequestModel inputData = new ReactionRequestModel(
                "heart", "123");

        // 3) Run the use case
        interactor.addReaction(inputData);

    }

    /**
     * Edge case where the test attempts to add a reaction to a message which
     * does not exist in the database. An error message specifying the message
     * does not exist should be returned.
     */
    @Test
    public void addReactionWhenMessageDoesNotExist() {
        // 1) Create prerequisite objects
        MessageRepoInt messageRepoInt = new MessageMemory();

        // Test reactions by adding a message manually
        List<String> list = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        MessageRepoRequestModel request = new MessageRepoRequestModel("hello","Michael","14",
                "123", list, now);
        messageRepoInt.save(request);

        ReactionOutputBoundary presenter = new ReactionOutputBoundary() {
            @Override
            public ReactionResponseModel prepareSuccessView(ReactionResponseModel reaction) {
                fail("Use case failure is unexpected.");
                return null;
            }

            @Override
            public ReactionResponseModel prepareFailView(String error) {
                // 4) Check that the Output Data and associated changes
                // are correct
                assertEquals("Message with ID: 999 does not exist.", error);
                return null;
            }
        };

        // 1) Create interactor
        ReactionInputBoundary interactor = new ReactionInteractor(
                messageRepoInt, presenter);

        // 2) Input data
        ReactionRequestModel inputData = new ReactionRequestModel(
                "smile", "999");

        // 3) Run the use case
        interactor.addReaction(inputData);

    }

    /**
     * Standard remove reaction test where a message is added manually with a
     * preexisting reaction, and it is checked whether that reaction can be removed
     * from the message in the database successfully.
     */
    @Test
    public void removeReaction() {
        // 1) Create prerequisite objects
        MessageRepoInt messageRepoInt = new MessageMemory();

        // Test reactions by adding a message manually
        // List must have the preexisting reaction
        List<String> list = new ArrayList<>();
        list.add("heart");
        LocalDateTime now = LocalDateTime.now();
        MessageRepoRequestModel request = new MessageRepoRequestModel("hello","Michael","14",
                "123", list, now);
        messageRepoInt.save(request);

        ReactionOutputBoundary presenter = new ReactionOutputBoundary() {
            @Override
            public ReactionResponseModel prepareSuccessView(ReactionResponseModel reaction) {
                // 4) Check that the Output Data and associated changes
                // are correct
                assertEquals("heart", reaction.getReaction());
                assertEquals("123", reaction.getMessageID());
                assertFalse(messageRepoInt.reactionExists("heart", "123"));
                return null;
            }

            @Override
            public ReactionResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        // 1) Create interactor
        ReactionInputBoundary interactor = new ReactionInteractor(
                messageRepoInt, presenter);

        // 2) Input data
        ReactionRequestModel inputData = new ReactionRequestModel(
                "heart", "123");

        // 3) Run the use case
        interactor.removeReaction(inputData);

    }

    /**
     * Edge case where the reaction attempting to be removed does not exist
     * on the message in the database. An error message specifying the reaction
     * does not exist on the message should be returned.
     */
    @Test
    public void removeReactionThatDoesNotExist() {
        // 1) Create prerequisite objects
        MessageRepoInt messageRepoInt = new MessageMemory();

        // Test reactions by adding a message manually
        // List must be empty
        List<String> emptyList = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        MessageRepoRequestModel request = new MessageRepoRequestModel("hello","Michael","14",
                "123", emptyList, now);
        messageRepoInt.save(request);

        ReactionOutputBoundary presenter = new ReactionOutputBoundary() {
            @Override
            public ReactionResponseModel prepareSuccessView(ReactionResponseModel reaction) {
                fail("Use case failure is unexpected.");
                return null;
            }

            @Override
            public ReactionResponseModel prepareFailView(String error) {
                // 4) Check that the Output Data and associated changes
                // are correct
                assertEquals("Reaction does not exists on message: 123", error);
                return null;
            }
        };

        // 1) Create interactor
        ReactionInputBoundary interactor = new ReactionInteractor(
                messageRepoInt, presenter);

        // 2) Input data
        ReactionRequestModel inputData = new ReactionRequestModel(
                "heart", "123");

        // 3) Run the use case
        interactor.removeReaction(inputData);

    }

    /**
     * Edge case where the test attempts to remove a reaction from a message which
     * does not exist in the database. An error message specifying the message
     * does not exist should be returned.
     */
    @Test
    public void removeReactionWhenMessageDoesNotExist() {
        // 1) Create prerequisite objects
        MessageRepoInt messageRepoInt = new MessageMemory();

        // Test reactions by adding a message manually
        List<String> list = new ArrayList<>();
        list.add("heart");
        LocalDateTime now = LocalDateTime.now();
        MessageRepoRequestModel request = new MessageRepoRequestModel("hello","Michael","14",
                "123", list, now);
        messageRepoInt.save(request);

        ReactionOutputBoundary presenter = new ReactionOutputBoundary() {
            @Override
            public ReactionResponseModel prepareSuccessView(ReactionResponseModel reaction) {
                fail("Use case failure is unexpected.");
                return null;
            }

            @Override
            public ReactionResponseModel prepareFailView(String error) {
                // 4) Check that the Output Data and associated changes
                // are correct
                assertEquals("Message with ID: 999 does not exist.", error);
                return null;
            }
        };

        // 1) Create interactor
        ReactionInputBoundary interactor = new ReactionInteractor(
                messageRepoInt, presenter);

        // 2) Input data
        ReactionRequestModel inputData = new ReactionRequestModel(
                "smile", "999");

        // 3) Run the use case
        interactor.removeReaction(inputData);

    }


}
