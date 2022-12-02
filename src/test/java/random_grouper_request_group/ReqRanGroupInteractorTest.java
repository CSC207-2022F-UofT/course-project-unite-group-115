package random_grouper_request_group;

import databases_classes.*;
import org.junit.Before;
import org.junit.Test;
import random_grouper_request_group.application_business_rules.ReqRanGroupInputBoundary;
import random_grouper_request_group.application_business_rules.ReqRanGroupInteractor;
import random_grouper_request_group.application_business_rules.ReqRanGroupRequestModel;
import random_grouper_request_group.application_business_rules.ReqRanGroupResponseModel;
import random_grouper_request_group.interface_adapters.GroupAdditionFailure;
import random_grouper_request_group.interface_adapters.ReqRanGroupPresenter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ReqRanGroupInteractorTest {
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
    public void testBasicRequest() {
        GroupRepoInt groupDatabase = new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        List<String> userGroups = new ArrayList<>();
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, interests, userGroups, emptyList, emptyList, LocalDateTime.now()));
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

        ReqRanGroupRequestModel inputData = new ReqRanGroupRequestModel("Danielle");

        interactor.requestRanGroup(inputData);
    }

    @Test
    public void testDiffOrder() {
        GroupRepoInt groupDatabase = new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        List<String> userGroups = new ArrayList<>();
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, interests, userGroups, emptyList, emptyList, LocalDateTime.now()));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO", "test", interests2, members, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("YES", "added", interests, members, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO2", "test2", interests2, members, true));

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

                Map<String, Object> groupFromDatabase3 = groupDatabase.getGroupInfo("test2");
                assertFalse(((List<String>) groupFromDatabase3.get("members")).contains("Danielle"));

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

        ReqRanGroupRequestModel inputData = new ReqRanGroupRequestModel("Danielle");

        interactor.requestRanGroup(inputData);
    }

    @Test
    public void testMultipleMatch() {
        GroupRepoInt groupDatabase = new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        List<String> userGroups = new ArrayList<>();
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, interests, userGroups, emptyList, emptyList, LocalDateTime.now()));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO", "test", interests2, members, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("YES", "added", interests, members, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO2", "test2", interests3, members, true));

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

                Map<String, Object> groupFromDatabase3 = groupDatabase.getGroupInfo("test2");
                assertFalse(((List<String>) groupFromDatabase3.get("members")).contains("Danielle"));

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

        ReqRanGroupRequestModel inputData = new ReqRanGroupRequestModel("Danielle");

        interactor.requestRanGroup(inputData);
    }

    @Test
    public void notAllInterestsMatch() {
        GroupRepoInt groupDatabase = new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        List<String> userGroups = new ArrayList<>();
        List<String> addedInterests = new ArrayList<>(interests);
        addedInterests.add("soul music");
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, interests, userGroups, emptyList, emptyList, LocalDateTime.now()));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO", "test", interests2, members, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("YES", "added", addedInterests, members, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO2", "test2", interests2, members, true));

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

                Map<String, Object> groupFromDatabase3 = groupDatabase.getGroupInfo("test2");
                assertFalse(((List<String>) groupFromDatabase3.get("members")).contains("Danielle"));

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

        ReqRanGroupRequestModel inputData = new ReqRanGroupRequestModel("Danielle");

        interactor.requestRanGroup(inputData);
    }

    @Test
    public void testOnlyMatchingGroupFull() {
        GroupRepoInt groupDatabase = new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        List<String> userGroups = new ArrayList<>();
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, interests, userGroups, emptyList, emptyList, LocalDateTime.now()));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO", "test", interests2, members, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO2", "full", interests, membersFull, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO3", "test2", interests2, members, true));

        // This creates an anonymous implementing class for the Output Boundary.
        ReqRanGroupPresenter presenter = new ReqRanGroupPresenter();
        ReqRanGroupInputBoundary interactor = new ReqRanGroupInteractor(groupDatabase, presenter, profileDatabase);
        ReqRanGroupRequestModel inputData = new ReqRanGroupRequestModel("Danielle");

        try {
            interactor.requestRanGroup(inputData);
            fail("Exception not thrown due to only matching group being full.");
        } catch (GroupAdditionFailure e) {
        }
    }

    @Test
    public void testBestGroupFull() {
        GroupRepoInt groupDatabase = new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        List<String> userGroups = new ArrayList<>();
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, interests, userGroups, emptyList, emptyList, LocalDateTime.now()));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO", "test", interests2, members, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO2", "full", interests, membersFull, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("YES", "added", interests3, members, true));

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

                Map<String, Object> groupFromDatabase3 = groupDatabase.getGroupInfo("full");
                assertFalse(((List<String>) groupFromDatabase3.get("members")).contains("Danielle"));

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

        ReqRanGroupRequestModel inputData = new ReqRanGroupRequestModel("Danielle");

        interactor.requestRanGroup(inputData);
    }

    @Test
    public void noMatchingGroups() {
        GroupRepoInt groupDatabase = new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        List<String> userGroups = new ArrayList<>();
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, interests, userGroups, emptyList, emptyList, LocalDateTime.now()));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO", "test", interests2, members, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO2", "test2", interests2, members, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO3", "test3", interests2, members, true));

        // This creates an anonymous implementing class for the Output Boundary.
        ReqRanGroupPresenter presenter = new ReqRanGroupPresenter();
        ReqRanGroupInputBoundary interactor = new ReqRanGroupInteractor(groupDatabase, presenter, profileDatabase);
        ReqRanGroupRequestModel inputData = new ReqRanGroupRequestModel("Danielle");

        try {
            interactor.requestRanGroup(inputData);
            fail("Exception not thrown due to only matching group being full.");
        } catch (GroupAdditionFailure e) {
        }
    }

    @Test
    public void testInBestGroup() {
        GroupRepoInt groupDatabase = new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        List<String> userGroups = new ArrayList<>();
        userGroups.add("test2");
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, interests, userGroups, emptyList, emptyList, LocalDateTime.now()));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO", "test", interests2, members, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("YES", "added", interests3, members, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO2", "test2", interests, members, true));

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

                Map<String, Object> groupFromDatabase3 = groupDatabase.getGroupInfo("test2");
                assertFalse(((List<String>) groupFromDatabase3.get("members")).contains("Danielle"));

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

        ReqRanGroupRequestModel inputData = new ReqRanGroupRequestModel("Danielle");

        interactor.requestRanGroup(inputData);
    }

    @Test
    public void testInMatchingGroup() {
        GroupRepoInt groupDatabase = new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        List<String> userGroups = new ArrayList<>();
        userGroups.add("test2");
        profileDatabase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, interests, userGroups, emptyList, emptyList, LocalDateTime.now()));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO", "test", interests2, members, true));
        groupDatabase.addGroup(new GroupRepoRequestModel("NO2", "test2", interests, members, true));

        // This creates an anonymous implementing class for the Output Boundary.
        ReqRanGroupPresenter presenter = new ReqRanGroupPresenter();
        ReqRanGroupInputBoundary interactor = new ReqRanGroupInteractor(groupDatabase, presenter, profileDatabase);
        ReqRanGroupRequestModel inputData = new ReqRanGroupRequestModel("Danielle");

        try {
            interactor.requestRanGroup(inputData);
            fail("Exception not thrown due to only matching group being full.");
        } catch (GroupAdditionFailure e) {
        }
    }
}
