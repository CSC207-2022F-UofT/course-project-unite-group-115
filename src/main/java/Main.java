import databases_classes.GroupDataAccess;
import databases_classes.ProfileManagerDataAccess;
import databases_classes.ProfileRepoInt;
import entities.RandomGroupFactory;
import databases_classes.GroupRepoInt;
import random_grouper_request_group.get_user_interests.application_business_rules.GetUserInterestsInteractor;
import random_grouper_request_group.get_user_interests.application_business_rules.GetUserInterestsOutputBoundary;
import random_grouper_create.application_business_rules.RanGroupCreateInputBoundary;
import random_grouper_create.application_business_rules.RanGroupCreateInteractor;
import random_grouper_create.application_business_rules.RanGroupCreateOutputBoundary;

import screens.RandomGroupCreationUI;
import random_grouper_request_group.get_user_interests.interface_adapters.GetUserInterestsController;
import random_grouper_request_group.get_user_interests.interface_adapters.GetUserInterestsPresenter;
import random_grouper_create.interface_adapters.RanGroupCreateControl;
import random_grouper_create.interface_adapters.RanGroupCreatePresenter;
import random_grouper_request_group.application_business_rules.ReqRanGroupInputBoundary;
import random_grouper_request_group.application_business_rules.ReqRanGroupInteractor;
import random_grouper_request_group.application_business_rules.ReqRanGroupOutputBoundary;
import screens.RequestRandomGroupUI;
import random_grouper_request_group.interface_adapters.ReqRanGroupController;
import random_grouper_request_group.interface_adapters.ReqRanGroupPresenter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        // Random Group Creation Window Creation
        JFrame groupCreationApplication = new JFrame("Random Group Creation");
        CardLayout groupCreationCardLayout = new CardLayout();
        JPanel groupCreationScreens = new JPanel(groupCreationCardLayout);
        groupCreationApplication.add(groupCreationScreens);

        // Parts for Random Group Creation Use Case
        GroupRepoInt groupData;
        try {
            groupData = new GroupDataAccess("./src/main/java/databases/groups.csv");
        }
        catch (IOException e) {
            throw new RuntimeException("Could not create group database file.");
        }
        ProfileRepoInt profileData;
        try {
            profileData = new ProfileManagerDataAccess("./src/main/java/databases/profiles.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        RanGroupCreateOutputBoundary ranGroupCreateOutputBoundary = new RanGroupCreatePresenter();
        RandomGroupFactory ranGroupFactory = new RandomGroupFactory();
        RanGroupCreateInputBoundary groupCreateInteractor = new RanGroupCreateInteractor(groupData,
                ranGroupCreateOutputBoundary, ranGroupFactory, profileData);
        RanGroupCreateControl groupCreateController = new RanGroupCreateControl(groupCreateInteractor);

        GetUserInterestsOutputBoundary getUserInterestsOutputBoundary = new GetUserInterestsPresenter();
        GetUserInterestsInteractor getUserInterestsInteractor = new
                GetUserInterestsInteractor(getUserInterestsOutputBoundary, profileData);
        GetUserInterestsController getUserInterestsController =
                new GetUserInterestsController(getUserInterestsInteractor);

        // Create Random Group Creation Screen
        // ToDo: need the logged in User's name
        String loggedInUser = "Tejas";
        RandomGroupCreationUI creationScreen = new RandomGroupCreationUI(groupCreateController,
                getUserInterestsController, loggedInUser);
        groupCreationScreens.add(creationScreen, "welcome");
        groupCreationCardLayout.show(groupCreationScreens, "create");
        groupCreationApplication.pack();

        // Create Request Random Group Window
        JFrame requestGroupApplication = new JFrame("Request Random Group");
        CardLayout requestGroupCardLayout = new CardLayout();
        JPanel requestGroupScreens = new JPanel(requestGroupCardLayout);
        requestGroupApplication.add(requestGroupScreens);

        // Create parts for Request Random Group Use Case
        ReqRanGroupOutputBoundary reqRanGroupOutputBoundary = new ReqRanGroupPresenter();
        ReqRanGroupInputBoundary reqRanGroupInteractor = new ReqRanGroupInteractor(groupData,
                reqRanGroupOutputBoundary, profileData);
        ReqRanGroupController reqRanGroupController = new ReqRanGroupController(reqRanGroupInteractor);

        // Create and Display Request Random Group Screen
        RequestRandomGroupUI reqGroupScreen = new RequestRandomGroupUI(reqRanGroupController, groupCreationApplication,
                loggedInUser);
        requestGroupScreens.add(reqGroupScreen, "welcome");
        requestGroupCardLayout.show(requestGroupScreens, "request");
        requestGroupApplication.pack();
        requestGroupApplication.setVisible(true);
    }
}
