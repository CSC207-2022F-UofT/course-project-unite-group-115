package profile_manager;

import database_classes.InMemoryProfileData;
import database_classes.ProfileRepoInt;
import entities.ProfileFactory;
import org.junit.Test;
import use_cases.profile_manager.application_business_rules.ProfileManagerInputBoundary;
import use_cases.profile_manager.application_business_rules.ProfileManagerInteractor;
import use_cases.profile_manager.application_business_rules.ProfileManagerRequestModel;
import use_cases.profile_manager.application_business_rules.ProfileManagerResponseModel;
import use_cases.profile_manager.interface_adapters.ProfileManagerPresenter;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class ProfileManagerInteractorTest {
    @Test
    public void create() {
        ProfileRepoInt ProfileRepository = new InMemoryProfileData();

        // This creates an anonymous implementing class for the Output Boundary.
        ProfileManagerPresenter presenter = new ProfileManagerPresenter() {
            @Override
            public ProfileManagerResponseModel prepareSuccessView(ProfileManagerResponseModel Profile) {
                // 4) Check that the Output Data and associated changes
                // are correct
                assertEquals("paul", Profile.getLogin());
                assertNotNull(Profile.getCreationTime()); // any creation time is fine.
                assertTrue(ProfileRepository.existsByName("paul"));
                return null;
            }

            @Override
            public ProfileManagerResponseModel prepareFailView(String error) {
                fail("Use case failure is unexpected.");
                return null;
            }
        };

        ProfileFactory ProfileFactory = new ProfileFactory();
        ProfileManagerInputBoundary interactor = new ProfileManagerInteractor(
                ProfileRepository, presenter, ProfileFactory);

        // 2) Input data — we can make this up for the test. Normally it would
        // be created by the Controller.
        ProfileManagerRequestModel inputData = new ProfileManagerRequestModel(
                "paul", "paul1234", LocalDate.of(2000,1,1), "Hi",
                new ArrayList<>(),new ArrayList<>(),new ArrayList<>());

        // 3) Run the use case
        interactor.create(inputData);
    }
}