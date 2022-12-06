package Reporter_Test;

import Reporter_Database.*;
import Reporter_Interface.UserReporterPresenter;
import Reporter_entities.UserFactory;
import get_user_sensitiveWordList.application_business_rules.GetUserInteractor;
import get_user_sensitiveWordList.application_business_rules.GetUserListRequestModel;
import get_user_sensitiveWordList.application_business_rules.GetUserListResponseModel;
import get_user_sensitiveWordList.interface_adapters.GetUserSenListPresenter;
import org.junit.Before;
import org.junit.Test;

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
        ProfileRepoInt profileDatabase = new InMemoryData();
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
        GetUserInteractor interactor = new GetUserInteractor(presenter, profileDatabase);

        GetUserListRequestModel inputData = new GetUserListRequestModel("Aurora");

        interactor.getUserSensWordList(inputData);




        }
    @Test(timeout = 50)
    public void testAddModel() throws IOException {
        GroupRepoInt Database = new InMemoryReporterData();

        Database.adduserModel(new RepoMessageModel(messageId, userId, message,
                reportUserId, LocalDateTime.now()));

        GroupRepoInt user;
        user = new UserDataAccess("java.report.csv");


        UserReporterPresenter presenter = new UserReporterPresenter() {
            @Override
            public UserMessageResponseModel prepareSuccessView(UserMessageResponseModel response) {
                assertEquals(messageId, response.getReport());
                assertNotNull(response.getTime());
                return null;
            }

            @Override
            public UserMessageResponseModel prepareFailView(String error) {
                fail("Message content can not be empty.");
                return null;
            }
        };

        UserFactory Factory = new UserFactory();
        InputBoundary interactor = new UserReporterInteractor(
                user, presenter, Factory);

        // 2) Input data — we can make this up for the test. Normally it would
        // be created by the Controller.
        UserMessageModel inputData = new UserMessageModel(
                messageId, userId, message, reportUserId);

        // 3) Run the use case
        interactor.create(inputData);
    }
}