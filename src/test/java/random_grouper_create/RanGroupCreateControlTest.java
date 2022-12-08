package random_grouper_create;

import database_classes.*;
import entities.RandomGroupFactory;
import org.junit.Before;
import org.junit.Test;
import use_cases.random_grouper_create.application_business_rules.RanGroupCreateInputBoundary;
import use_cases.random_grouper_create.application_business_rules.RanGroupCreateInteractor;
import use_cases.random_grouper_create.application_business_rules.RanGroupCreateResponseModel;
import use_cases.random_grouper_create.interface_adapters.RanGroupCreateControl;
import use_cases.random_grouper_create.interface_adapters.RanGroupCreatePresenter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class RanGroupCreateControlTest {
    List<String> interests = new ArrayList<>();
    List<String> members = new ArrayList<>();

    @Before
    public void setUp() {
        interests.add("blue");
        interests.add("chocolate");
        interests.add("video games");

        members.add("James");
        members.add("Chloe");
    }

    @Test
    public void testBasicCreate() {
        GroupRepoInt groupDatabase = new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        List<String> userGroups = new ArrayList<>();
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, interests, userGroups, emptyList, "", LocalDateTime.now()));

        // This creates an anonymous implementing class for the Output Boundary.
        RanGroupCreatePresenter presenter = new RanGroupCreatePresenter() {
            @Override
            public RanGroupCreateResponseModel prepareSuccessView(RanGroupCreateResponseModel responseModel) {
                assertTrue(responseModel.isSuccess());
                assertEquals("Buddies", responseModel.getCreatedGroupName());
                assertNotNull(responseModel.getCreationTime()); // any creation time is fine.

                Map<String, Object> groupFromDatabase = groupDatabase.getGroupInfo(responseModel.getCreatedGroupID());
                assertEquals("Buddies", groupFromDatabase.get("group name"));

                List<String> currentMembers = new ArrayList<>();
                currentMembers.add("Danielle");
                assertEquals(currentMembers, groupFromDatabase.get("members"));

                assertEquals(interests, groupFromDatabase.get("interests"));
                assertEquals(true, groupFromDatabase.get("random group?"));
                return null;
            }

            @Override
            public RanGroupCreateResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        RandomGroupFactory groupFactory = new RandomGroupFactory();
        RanGroupCreateInputBoundary interactor = new RanGroupCreateInteractor(groupDatabase, presenter, groupFactory,
                profileDatabase);

        RanGroupCreateControl controller = new RanGroupCreateControl(interactor);
        controller.createGroup("Buddies", interests, "Danielle");
    }
}
