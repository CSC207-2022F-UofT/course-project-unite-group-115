import database_classes.ProfileManagerDataAccess;
import database_classes.ProfileRepoInt;
import entities.RandomGroupFactory;
import database_classes.GroupRepoInt;
import random_grouper_request_group.get_user_interests.application_business_rules.GetUserInterestsInteractor;
import random_grouper_request_group.get_user_interests.application_business_rules.GetUserInterestsOutputBoundary;
import random_grouper_create.application_business_rules.*;

import database_classes.GroupDataAccess;
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
        // Random Group Creation Test
        JFrame application = new JFrame("Random Group Creation Test");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // Create the parts to plug into the Use Case+Entities
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

        // ToDo: need the logged in User's name
        String loggedInUser = "Tejas";
        RandomGroupCreationUI createScreen = new RandomGroupCreationUI(groupCreateController,
                getUserInterestsController, loggedInUser);
        screens.add(createScreen, "welcome");
        cardLayout.show(screens, "create");
        application.pack();
        application.setVisible(true);

        // Request Random Group Test
        JFrame application2 = new JFrame("Request Random Group Test");
        CardLayout cardLayout2 = new CardLayout();
        JPanel screen2 = new JPanel(cardLayout2);
        application2.add(screen2);

        ReqRanGroupOutputBoundary reqRanGroupOutputBoundary = new ReqRanGroupPresenter();
        ReqRanGroupInputBoundary reqRanGroupInteractor = new ReqRanGroupInteractor(groupData,
                reqRanGroupOutputBoundary, profileData);
        ReqRanGroupController reqRanGroupController = new ReqRanGroupController(reqRanGroupInteractor);

        RequestRandomGroupUI reqGroupScreen = new RequestRandomGroupUI(reqRanGroupController, loggedInUser);
        screen2.add(reqGroupScreen, "welcome");
        cardLayout2.show(screen2, "request");
        application2.pack();
        application2.setVisible(true);
    }
}
