package random_grouper_request_group;

import database_classes.InMemoryProfileData;
import database_classes.ProfileRepoInt;
import database_classes.ProfileRepoRequestModel;
import org.junit.Before;
import org.junit.Test;
import get_user_interests.application_business_rules.GetUserInterestsInteractor;
import get_user_interests.application_business_rules.GetUserInterestsRequestModel;
import get_user_interests.application_business_rules.GetUserInterestsResponseModel;
import get_user_interests.interface_adapters.GetUserInterestsFailure;
import get_user_interests.interface_adapters.GetUserInterestsPresenter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.fail;

public class GetUserInterestsInteractorTest {
    List<String> interests = new ArrayList<>();
    List<String> interests2 = new ArrayList<>();
    List<String> interests3 = new ArrayList<>();
    List<String> members = new ArrayList<>();
    List<String> membersFull = new ArrayList<>();

    @Before
    public void setUp() {
        interests.add("blue");
        interests.add("chocolate");
        interests.add("video games");

        interests2.add("harp");
        interests2.add("dancing");

        interests3.add("blue");

        members.add("James");
        members.add("Chloe");

        membersFull.add("1");
        membersFull.add("2");
        membersFull.add("3");
        membersFull.add("4");
        membersFull.add("5");
        membersFull.add("6");
        membersFull.add("7");
        membersFull.add("8");
    }

    @Test
    public void testBasicGetInterests() {
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        List<String> userGroups = new ArrayList<>();
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, interests, userGroups, emptyList, "", LocalDateTime.now()));

        // This creates an anonymous implementing class for the Output Boundary.
        GetUserInterestsPresenter presenter = new GetUserInterestsPresenter() {
            @Override
            public GetUserInterestsResponseModel prepareSuccessView(GetUserInterestsResponseModel responseModel) {
                assertEquals(interests, responseModel.getInterests());
                return null;
            }

            @Override
            public GetUserInterestsResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        GetUserInterestsInteractor interactor = new GetUserInterestsInteractor(presenter, profileDatabase);

        GetUserInterestsRequestModel inputData = new GetUserInterestsRequestModel("Danielle");

        interactor.getUserInterests(inputData);
    }

    @Test
    public void testUserDoesntExist() {
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        List<String> userGroups = new ArrayList<>();
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, interests, userGroups, emptyList, "", LocalDateTime.now()));

        // This creates an anonymous implementing class for the Output Boundary.
        GetUserInterestsPresenter presenter = new GetUserInterestsPresenter();
        GetUserInterestsInteractor interactor = new GetUserInterestsInteractor(presenter, profileDatabase);
        GetUserInterestsRequestModel inputData = new GetUserInterestsRequestModel("Joe");

        try {
            interactor.getUserInterests(inputData);
            fail("Exception not thrown due to user not existing.");
        } catch (GetUserInterestsFailure e) {
        }
    }
}


