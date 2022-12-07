package Test;

import Block_User_Application.application_business_rules.*;
import Block_User_Application.interface_adapters.UserReporterPresenter;
import add_blocked_Users.application_business_rules.*;
import database_classes.*;
import entities.BlockerFactory;
import get_user_sensitiveWordList.application_business_rules.GetUserSensWordListInteractor;
import get_user_sensitiveWordList.application_business_rules.GetUserListRequestModel;
import get_user_sensitiveWordList.application_business_rules.GetUserListResponseModel;
import get_user_sensitiveWordList.interface_adapters.GetUserSenListPresenter;
import org.junit.Before;
import org.junit.Test;
import reaction_use_case.application_business_rules.ReactionInputBoundary;
import reaction_use_case.application_business_rules.ReactionInteractor;
import reaction_use_case.application_business_rules.ReactionRequestModel;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class InteractorTest {
    List<String> wordList = new ArrayList<>();
    String messageId;

    String userId;

    String message;

    String reportUserId;
    String BlockList = "Aurora";


    @Before
    public void setUp() {
        wordList.add("alpha");
        wordList.add("beta");
        wordList.add("Pink");
        messageId = "1";
        userId = "Ellen";
        message="ellen is big";
        reportUserId = "Aurora";


    }

    @Test(timeout = 50)
    public void testBasicCreate() {
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        profileDatabase.save(new ProfileRepoRequestModel("Aurora", "auro", LocalDate.now(),
                "", emptyList, wordList, emptyList, emptyList, emptyList, "", LocalDateTime.now()));


        GetUserSenListPresenter presenter = new GetUserSenListPresenter() {
            @Override
            public GetUserListResponseModel prepareSuccessView(GetUserListResponseModel responseModel) {
                assertEquals(wordList, responseModel.getSensList());
                return null;

            }

            @Override
            public GetUserListResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };
        GetUserSensWordListInteractor interactor = new GetUserSensWordListInteractor(presenter, profileDatabase);

        GetUserListRequestModel inputData = new GetUserListRequestModel("Aurora");

        interactor.getUserSensWordList(inputData);




        }
    @Test(timeout = 50)
    public void testAddModel() throws IOException {
        UserReporterInt Database = new InMemoryReporterData();

        Database.adduserModel(new UserReporterRepoRequestModel(messageId, userId, message,
                reportUserId, LocalDateTime.now()));

        UserReporterInt user;
        user = new UserreporterDataAccess("./src/main/java/databases/java.report.csv");


        UserReporterPresenter presenter = new UserReporterPresenter() {
            @Override
            public UserReporterResponseModel prepareSuccessView(UserReporterResponseModel response) {
                assertEquals(messageId, response.getReport());
                assertNotNull(response.getTime());
                return null;
            }

            @Override
            public UserReporterResponseModel prepareFailView(String error) {
                fail("Message content can not be empty.");
                return null;
            }
        };

        BlockerFactory Factory = new BlockerFactory();
        UserReporterInputBoundary interactor = new UserReporterInteractor(
                user, presenter, Factory);

        // 2) Input data — we can make this up for the test. Normally it would
        // be created by the Controller.
        UserReporterRequestModel inputData = new UserReporterRequestModel(
                messageId, userId, message, reportUserId);

        // 3) Run the use case
        interactor.create(inputData);
    }
    @Test(timeout = 50)
    public void testAddBlockUser() throws IOException{
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        profileDatabase.save(new ProfileRepoRequestModel("Ellen", "Ell", LocalDate.now(),
                "hello", emptyList, wordList, emptyList, emptyList, emptyList, BlockList, LocalDateTime.now()));
        //profileDatabase.addBlockedUserToProfile("Ellen","Alpha");
        AddBlockedUserOutputBoundary presenter = new AddBlockedUserOutputBoundary() {
            @Override
            public AddBlockedUserResponseModel prepareSuccessView(AddBlockedUserResponseModel response) {
                assertEquals("Aurora;Alpha", response.getBlockedList());

                return null;
            }

            @Override
            public AddBlockedUserResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };
        AddblockedUserInputBoundary interactor = new AddBlockedUserInteractor(
                presenter,profileDatabase) ;

        // 2) Input data
        AddBlockedUserRequestModel inputData = new AddBlockedUserRequestModel(
                "Ellen", "Alpha");

        // 3) Run the use case
        interactor.AddBlockedUser(inputData);
    }
}