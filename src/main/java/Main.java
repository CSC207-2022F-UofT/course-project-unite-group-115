import entities.RandomGroupFactory;
import random_grouper.application_business_rules.GroupRepoInt;
import random_grouper.application_business_rules.RanGroupCreateInputBoundary;
import random_grouper.application_business_rules.RanGroupCreateInteractor;
import random_grouper.application_business_rules.RanGroupCreateOutputBoundary;

import random_grouper.frameworks_and_drivers.GroupDataAccess;
import random_grouper.frameworks_and_drivers.RandomGroupCreationUI;
import random_grouper.interface_adapters.RanGroupCreateControl;
import random_grouper.interface_adapters.RanGroupCreatePresenter;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args){
        JFrame application = new JFrame("Random Group Creation Test");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // Create the parts to plug into the Use Case+Entities
        // ToDo: Can be changed - created so that rest of code compiles
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

        RandomGroupCreationUI createScreen = new RandomGroupCreationUI(controller);
        screens.add(createScreen, "welcome");
        cardLayout.show(screens, "create");
        application.pack();
        application.setVisible(true);
    }
}
