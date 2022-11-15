import entities.RandomGroupFactory;
import database_classes.GroupRepoInt;
import random_grouper_create.application_business_rules.RanGroupCreateInputBoundary;
import random_grouper_create.application_business_rules.RanGroupCreateInteractor;
import random_grouper_create.application_business_rules.RanGroupCreateOutputBoundary;

import database_classes.GroupDataAccess;
import random_grouper_create.frameworks_and_drivers.RandomGroupCreationUI;
import random_grouper_create.interface_adapters.RanGroupCreateControl;
import random_grouper_create.interface_adapters.RanGroupCreatePresenter;
import random_grouper_request_group.application_business_rules.ReqRanGroupInputBoundary;
import random_grouper_request_group.application_business_rules.ReqRanGroupInteractor;
import random_grouper_request_group.application_business_rules.ReqRanGroupOutputBoundary;
import random_grouper_request_group.frameworks_and_drivers.RequestRandomGroupUI;
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
        // ToDo: Can be changed - created for testing
        GroupRepoInt groupData;
        try {
            groupData = new GroupDataAccess("./groups.csv");
        }
        catch (IOException e) {
            throw new RuntimeException("Could not create group database file.");
        }
        UserRepoInt userData;
        try {
            userData = new UserDataAccess("./users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        RanGroupCreateOutputBoundary ranGroupCreateOutputBoundary = new RanGroupCreatePresenter();
        RandomGroupFactory ranGroupFactory = new RandomGroupFactory();
        RanGroupCreateInputBoundary interactor = new RanGroupCreateInteractor(groupData,
                ranGroupCreateOutputBoundary, ranGroupFactory, userData);
        RanGroupCreateControl controller = new RanGroupCreateControl(interactor);

        // ToDo: need the logged in User's name
        String loggedInUser = "";
        RandomGroupCreationUI createScreen = new RandomGroupCreationUI(controller, loggedInUser);
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
                reqRanGroupOutputBoundary, userData);
        ReqRanGroupController reqRanGroupController = new ReqRanGroupController(reqRanGroupInteractor);

        RequestRandomGroupUI reqGroupScreen = new RequestRandomGroupUI(reqRanGroupController, loggedInUser);
        screen2.add(reqGroupScreen, "welcome");
        cardLayout2.show(screen2, "request");
        application2.pack();
        application2.setVisible(true);
    }
}
