package random_grouper_request_group;

import databases.*;
import org.junit.Before;
import org.junit.Test;
import random_grouper_request_group.application_business_rules.ReqRanGroupInputBoundary;
import random_grouper_request_group.application_business_rules.ReqRanGroupInteractor;
import random_grouper_request_group.application_business_rules.ReqRanGroupRequestModel;
import random_grouper_request_group.application_business_rules.ReqRanGroupResponseModel;
import random_grouper_request_group.get_user_interests.application_business_rules.GetUserInterestsInteractor;
import random_grouper_request_group.get_user_interests.application_business_rules.GetUserInterestsRequestModel;
import random_grouper_request_group.get_user_interests.application_business_rules.GetUserInterestsResponseModel;
import random_grouper_request_group.get_user_interests.interface_adapters.GetUserInterestsFailure;
import random_grouper_request_group.get_user_interests.interface_adapters.GetUserInterestsPresenter;
import random_grouper_request_group.interface_adapters.GroupAdditionFailure;
import random_grouper_request_group.interface_adapters.ReqRanGroupPresenter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
                "", emptyList, emptyList, interests, userGroups, emptyList, emptyList, LocalDateTime.now()));

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
                "", emptyList, emptyList, interests, userGroups, emptyList, emptyList, LocalDateTime.now()));

        // This creates an anonymous implementing class for the Output Boundary.
        GetUserInterestsPresenter presenter = new GetUserInterestsPresenter();
        GetUserInterestsInteractor interactor = new GetUserInterestsInteractor(presenter, profileDatabase);
        GetUserInterestsRequestModel inputData = new GetUserInterestsRequestModel("Joe");

        try {
            interactor.getUserInterests(inputData);
            fail("Exception not thrown due to only matching group being full.");
        } catch (GetUserInterestsFailure e) {
        }
    }
}


