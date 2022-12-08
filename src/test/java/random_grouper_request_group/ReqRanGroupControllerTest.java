package random_grouper_request_group;

import database_classes.*;
import org.junit.Before;
import org.junit.Test;
import random_grouper_request_group.application_business_rules.ReqRanGroupInputBoundary;
import random_grouper_request_group.application_business_rules.ReqRanGroupInteractor;
import random_grouper_request_group.application_business_rules.ReqRanGroupResponseModel;
import random_grouper_request_group.interface_adapters.ReqRanGroupController;
import random_grouper_request_group.interface_adapters.ReqRanGroupPresenter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ReqRanGroupControllerTest {
    List<String> interests = new ArrayList<>();
    List<String> interests2 = new ArrayList<>();
    List<String> members = new ArrayList<>();

    @Before
    public void setUp() {
        interests.add("blue");
        interests.add("chocolate");
        interests.add("video games");

        interests2.add("harp");
        interests2.add("dancing");

        members.add("James");
        members.add("Chloe");
    }

    @Test
    public void testBasicRequest() {
        GroupRepoInt groupDatabase = (GroupRepoInt) new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        List<String> userGroups = new ArrayList<>();
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, interests, userGroups, emptyList, "", LocalDateTime.now()));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO", "test", interests2, members, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("YES", "added", interests, members, true));

        // This creates an anonymous implementing class for the Output Boundary.
        ReqRanGroupPresenter presenter = new ReqRanGroupPresenter() {
            @Override
            public ReqRanGroupResponseModel prepareSuccessView(ReqRanGroupResponseModel responseModel) {
                assertEquals("added", responseModel.getAddedToGroupID());
                assertEquals("YES", responseModel.getAddedToGroupName());

                Map<String, Object> groupFromDatabase = groupDatabase.getGroupInfo(responseModel.getAddedToGroupID());
                assertTrue(((List<String>) groupFromDatabase.get("members")).contains("Danielle"));
                assertEquals(3, ((List<String>) groupFromDatabase.get("members")).size());
                Map<String, Object> groupFromDatabase2 = groupDatabase.getGroupInfo("test");
                assertFalse(((List<String>) groupFromDatabase2.get("members")).contains("Danielle"));

                List<String> currentMembers = new ArrayList<>(members);
                currentMembers.add("Danielle");
                assertEquals(currentMembers, groupFromDatabase.get("members"));

                assertTrue(profileDatabase.getGroups("Danielle").contains("added"));

                return null;
            }

            @Override
            public ReqRanGroupResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        ReqRanGroupInputBoundary interactor = new ReqRanGroupInteractor(groupDatabase, presenter, profileDatabase);

        ReqRanGroupController controller = new ReqRanGroupController(interactor);
        controller.requestRanGroup("Danielle");
    }
}