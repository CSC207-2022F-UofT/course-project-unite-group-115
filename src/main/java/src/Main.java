import database_classes.GroupDataAccess;
import general_group.entities.GeneralGroupFactory;
import general_group.interface_adapters.GeneralGroupCreateController;
import general_group.interface_adapters.GeneralGroupCreatePresenter;
import general_group.screens.GeneralGroupCreationScreen;
import general_group.use_case.GeneralGroupCreateInteractor;
import general_group.use_case.GeneralGroupCreateOutputBoundary;
import general_group.use_case.GroupRepoInt;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        JFrame application = new JFrame("General group build test");
        application.setSize(900, 900);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // Create the parts to plug into the Use Case+Entities
        GroupRepoInt groupData;
        try {
            groupData = new GroupDataAccess("./groups.csv");
        }
        catch (IOException e) {
            throw new RuntimeException("Could not create group database file.");
        }

        GeneralGroupCreateOutputBoundary outputBoundary = new GeneralGroupCreatePresenter();
        GeneralGroupFactory groupFactory = new GeneralGroupFactory();
        GeneralGroupCreateInteractor interactor = new GeneralGroupCreateInteractor(groupData, outputBoundary,
                groupFactory);
        GeneralGroupCreateController controller = new GeneralGroupCreateController(interactor);

        GeneralGroupCreationScreen generalGroupCreationScreen = new GeneralGroupCreationScreen(controller);
        screens.add(generalGroupCreationScreen, "Welcome!");
        cardLayout.show(screens, "create");
        application.pack();
        application.setVisible(true);

    }
}
