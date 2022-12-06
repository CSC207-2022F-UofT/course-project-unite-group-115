package get_groups;

import database_classes.*;
import get_groups.application_business_rules.GetGroupsInteractor;
import get_groups.application_business_rules.GetGroupsRequestModel;
import get_groups.application_business_rules.GetGroupsResponseModel;
import get_groups.interface_adapters.GetGroupsPresenter;
import org.junit.Before;
import org.junit.Test;
import random_grouper_request_group.get_user_interests.application_business_rules.GetUserInterestsInteractor;
import random_grouper_request_group.get_user_interests.application_business_rules.GetUserInterestsRequestModel;
import random_grouper_request_group.get_user_interests.interface_adapters.GetUserInterestsFailure;
import random_grouper_request_group.get_user_interests.interface_adapters.GetUserInterestsPresenter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GetGroupsInteractorTest {
    List<String> groups = new ArrayList<>();
    List<String> members = new ArrayList<>();

    @Before
    public void setUp() {
        groups.add("1");
        groups.add("2");
        groups.add("3");

        members.add("Danielle");
    }

    @Test
    public void testBasicGetGroups() {
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, emptyList, groups, emptyList, emptyList, LocalDateTime.now()));

        GroupRepoInt groupDatabase = new InMemoryGroupData();
        GroupRepoRequestModel group1 = new GroupRepoRequestModel("blue", "1", emptyList, members, true);
        GroupRepoRequestModel group2 = new GroupRepoRequestModel("chocolate", "2", emptyList, members, true);
        GroupRepoRequestModel group3 = new GroupRepoRequestModel("video games", "3", emptyList, members, true);
        groupDatabase.addGroup(group1);
        groupDatabase.addGroup(group2);
        groupDatabase.addGroup(group3);

        // This creates an anonymous implementing class for the Output Boundary.
        GetGroupsPresenter presenter = new GetGroupsPresenter() {
            @Override
            public GetGroupsResponseModel prepareSuccessView(GetGroupsResponseModel responseModel) {
                Map<String, String> expected = new HashMap<>();
                expected.put("blue", "1");
                expected.put("chocolate", "2");
                expected.put("video games", "3");
                assertEquals(groups, responseModel.getGroupNames());
                assertEquals(expected, responseModel.getGroups());
                return null;
            }

            @Override
            public GetGroupsResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        GetGroupsInteractor interactor = new GetGroupsInteractor(presenter, profileDatabase, groupDatabase);

        GetGroupsRequestModel inputData = new GetGroupsRequestModel("Danielle");

        interactor.getUsersGroups(inputData);
    }

    @Test
    public void testUserDoesntExist() {
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, emptyList, groups, emptyList, emptyList, LocalDateTime.now()));

        GroupRepoInt groupDatabase = new InMemoryGroupData();
        GroupRepoRequestModel group1 = new GroupRepoRequestModel("blue", "1", emptyList, members, true);
        GroupRepoRequestModel group2 = new GroupRepoRequestModel("chocolate", "2", emptyList, members, true);
        GroupRepoRequestModel group3 = new GroupRepoRequestModel("video games", "3", emptyList, members, true);
        groupDatabase.addGroup(group1);
        groupDatabase.addGroup(group2);
        groupDatabase.addGroup(group3);

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
