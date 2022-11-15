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
        // Random Group Creation Window Creation
        JFrame groupCreationApplication = new JFrame("Random Group Creation Test");
        CardLayout groupCreationCardLayout = new CardLayout();
        JPanel groupCreationScreens = new JPanel(groupCreationCardLayout);
        groupCreationApplication.add(groupCreationScreens);

        // Create the parts to plug into the Use Case+Entities
        GroupRepoInt groupData;
        try {
            groupData = new GroupDataAccess("./groups.csv");
        }
        catch (IOException e) {
            throw new RuntimeException("Could not create group database file.");
        }
        RanGroupCreateOutputBoundary ranGroupCreateOutputBoundary = new RanGroupCreatePresenter();
        RandomGroupFactory ranGroupFactory = new RandomGroupFactory();
        RanGroupCreateInputBoundary interactor = new RanGroupCreateInteractor(groupData,
                ranGroupCreateOutputBoundary, ranGroupFactory);
        RanGroupCreateControl controller = new RanGroupCreateControl(interactor);

        RandomGroupCreationUI creationScreen = new RandomGroupCreationUI(controller);
        groupCreationScreens.add(creationScreen, "welcome");
        groupCreationCardLayout.show(groupCreationScreens, "create");
        groupCreationApplication.pack();

        // Request Random Group Test
        JFrame requestGroupApplication = new JFrame("Request Random Group Test");
        CardLayout requestGroupCardLayout = new CardLayout();
        JPanel requestGroupScreens = new JPanel(requestGroupCardLayout);
        requestGroupApplication.add(requestGroupScreens);

        ReqRanGroupOutputBoundary reqRanGroupOutputBoundary = new ReqRanGroupPresenter();
        ReqRanGroupInputBoundary reqRanGroupInteractor = new ReqRanGroupInteractor(groupData,
                reqRanGroupOutputBoundary);
        ReqRanGroupController reqRanGroupController = new ReqRanGroupController(reqRanGroupInteractor);

        RequestRandomGroupUI reqGroupScreen = new RequestRandomGroupUI(reqRanGroupController,groupCreationApplication);
        requestGroupScreens.add(reqGroupScreen, "welcome");
        requestGroupCardLayout.show(requestGroupScreens, "request");
        requestGroupApplication.pack();
        requestGroupApplication.setVisible(true);
    }
}
