package general_group_create;

import database_classes.InMemoryGroupData;
import database_classes.InMemoryProfileData;
import database_classes.ProfileRepoInt;
import database_classes.ProfileRepoRequestModel;
import entities.GeneralGroupFactory;
import use_cases.general_group.interface_adapters.GenGroupCreationFailed;
import use_cases.general_group.interface_adapters.GeneralGroupCreatePresenter;
import org.junit.Before;
import org.junit.Test;
import use_cases.general_group.use_case.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class GenGroupInteractorUnitTest {
    List<String> interests = new ArrayList<>();
    List<String> members = new ArrayList<>();

    @Before
    public void setUp() {
        members.add("James");
        members.add("Chloe");
    }

    @Test
    public void testGeneralGroupBasicCreation() {
        InMemoryGroupData groupDataBase = new InMemoryGroupData();
        ProfileRepoInt profileDataBase = new InMemoryProfileData();
        List<String> emptyList = new ArrayList<>();
        List<String> userGroups = new ArrayList<>();
        profileDataBase.save(new ProfileRepoRequestModel("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, interests, userGroups, emptyList, "", LocalDateTime.now()));

        GeneralGroupCreatePresenter presenter = new GeneralGroupCreatePresenter() {
            @Override
            public GeneralGroupCreateDsResponseModel prepareSuccessView(GeneralGroupCreateDsResponseModel responseModel) {
                assertTrue(responseModel.isSuccess());
                assertEquals("Buddies", responseModel.getGroupName());
                assertNotNull(responseModel.getCreationTime()); // any creation time is fine.

                Map<String, Object> groupFromDatabase = groupDataBase.getGroupInfo(responseModel.getGroupID());
                assertEquals("Buddies", groupFromDatabase.get("group name"));

                List<String> currentMembers = new ArrayList<>();
                currentMembers.add("James");
                currentMembers.add("Chloe");
                currentMembers.add("Danielle");
                assertEquals(currentMembers, groupFromDatabase.get("members"));

                assertEquals(interests, groupFromDatabase.get("interests"));
                assertEquals(false, groupFromDatabase.get("random group?"));

                assertTrue(profileDataBase.getGroups("Danielle").contains(responseModel.getGroupID()));

                return null;
            }

            @Override
            public GeneralGroupCreateDsResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        GeneralGroupFactory groupFactory = new GeneralGroupFactory();
        GeneralGroupCreateInputBoundary interactor = new GeneralGroupCreateInteractor(groupDataBase, presenter,
                groupFactory, profileDataBase);

        GeneralGroupCreateDsRequestModel inputData = new GeneralGroupCreateDsRequestModel(
                "Buddies", members, "Danielle");

        interactor.create(inputData);
    }

    @Test
    public void testCreateFailEmptyString() {
        GeneralGroupRepoInt groupDatabase = new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();

        GeneralGroupCreatePresenter presenter = new GeneralGroupCreatePresenter();

        GeneralGroupFactory groupFactory = new GeneralGroupFactory();
        GeneralGroupCreateInputBoundary interactor = new GeneralGroupCreateInteractor(groupDatabase, presenter, groupFactory,
                profileDatabase);

        GeneralGroupCreateDsRequestModel inputData = new GeneralGroupCreateDsRequestModel(
                "", members, "Danielle");

        try {
            interactor.create(inputData);
            fail("Exception not thrown due to empty string as the group name.");
        } catch (GenGroupCreationFailed e) {
        }
    }

    @Test
    public void testCreateFailEmptyFriendList() {
        GeneralGroupRepoInt groupDatabase = new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();

        GeneralGroupCreatePresenter presenter = new GeneralGroupCreatePresenter();

        GeneralGroupFactory groupFactory = new GeneralGroupFactory();
        GeneralGroupCreateInputBoundary interactor = new GeneralGroupCreateInteractor(groupDatabase, presenter, groupFactory,
                profileDatabase);

        List<String> emptyList = new ArrayList<>();
        GeneralGroupCreateDsRequestModel inputData = new GeneralGroupCreateDsRequestModel(
                "Yo", emptyList, "Danielle");

        try {
            interactor.create(inputData);
            fail("Exception not thrown due to a list of no friends being selected.");
        } catch (GenGroupCreationFailed e) {
        }

    }

    @Test
    public void testCreateFailTooManyFriends() {
        GeneralGroupRepoInt groupDatabase = new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();

        GeneralGroupCreatePresenter presenter = new GeneralGroupCreatePresenter();

        GeneralGroupFactory groupFactory = new GeneralGroupFactory();
        GeneralGroupCreateInputBoundary interactor = new GeneralGroupCreateInteractor(groupDatabase, presenter, groupFactory,
                profileDatabase);

        String[] names = new String[] {"James", "Chloe", "Ali", "Norman", "Davis", "Green", "Lowry", "Fred"};
        List<String> fullList = new ArrayList<>(Arrays.asList(names));
        GeneralGroupCreateDsRequestModel inputData = new GeneralGroupCreateDsRequestModel(
                "Yo", fullList, "Danielle");

        try {
            interactor.create(inputData);
            fail("Exception not thrown due to a list of too many members being added.");
        }catch (GenGroupCreationFailed e) {
        }

    }

    @Test
    public void testCreateFailDuplicateMembers() {
        GeneralGroupRepoInt groupDatabase = new InMemoryGroupData();
        ProfileRepoInt profileDatabase = new InMemoryProfileData();

        GeneralGroupCreatePresenter presenter = new GeneralGroupCreatePresenter();

        GeneralGroupFactory groupFactory = new GeneralGroupFactory();
        GeneralGroupCreateInputBoundary interactor = new GeneralGroupCreateInteractor(groupDatabase, presenter, groupFactory,
                profileDatabase);

        String[] names = new String[] {"James", "Chloe", "Ali", "Ali"};
        List<String> fullList = new ArrayList<>(Arrays.asList(names));
        GeneralGroupCreateDsRequestModel inputData = new GeneralGroupCreateDsRequestModel(
                "Yo", fullList, "Danielle");

        try {
            interactor.create(inputData);
            fail("Exception not thrown due to a list duplicate members being added.");
        }catch (GenGroupCreationFailed e) {
        }
    }

}
