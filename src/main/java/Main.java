import database_classes.GroupDataAccess;
import database_classes.ProfileManagerDataAccess;
import database_classes.ProfileRepoInt;
import general_group.entities.GeneralGroupFactory;
import general_group.interface_adapters.GeneralGroupCreateController;
import general_group.interface_adapters.GeneralGroupCreatePresenter;
import general_group.screens.GeneralGroupCreationScreen;
import general_group.use_case.GeneralGroupCreateInteractor;
import general_group.use_case.GeneralGroupCreateOutputBoundary;
import general_group.use_case.GroupRepoInt;
import get_friends.entities.Profile;
import get_friends.entities.ProfileFactory;
import get_friends.interface_adapters.GetFriendsController;
import get_friends.interface_adapters.GetFriendsPresenter;
import get_friends.use_case.GetFriendsInteractor;
import get_friends.use_case.GetFriendsOutputBoundary;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        JFrame application = new JFrame("General group build test");
        application.setSize(200, 200);
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // Create the parts to plug into the Use Case+Entities
        GroupRepoInt groupData;
        try {
            groupData = new GroupDataAccess("./src/main/java/database_classes/groups.csv");
        }
        catch (IOException e) {
            throw new RuntimeException("Could not create group database file.");
        }

        ProfileRepoInt profileData;
        try {
            profileData = new ProfileManagerDataAccess("./src/main/java/database_classes/profiles.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }

        GeneralGroupCreateOutputBoundary genGroupOutputBoundary = new GeneralGroupCreatePresenter();
        GeneralGroupFactory groupFactory = new GeneralGroupFactory();
        GeneralGroupCreateInteractor genGroupInteractor = new GeneralGroupCreateInteractor(groupData,
                genGroupOutputBoundary, groupFactory, profileData);
        GeneralGroupCreateController genGroupController = new GeneralGroupCreateController(genGroupInteractor);

        //Testing with a random profile, must change later on
        java.util.List<String> friendList = new ArrayList<>();
        friendList.add("a");
        friendList.add("b");
        friendList.add("C");
        List<String> emptyList = new ArrayList<>();
        Profile testProfile = ProfileFactory.create("Danielle", "Dani", LocalDate.now(),
                "", emptyList, emptyList, emptyList, emptyList, friendList, emptyList);

        GetFriendsOutputBoundary friendsOutputBoundary = new GetFriendsPresenter();
        GetFriendsInteractor friendsInteractor = new GetFriendsInteractor(friendsOutputBoundary);
        GetFriendsController friendsController = new GetFriendsController(friendsInteractor);

        GeneralGroupCreationScreen generalGroupCreationScreen = new GeneralGroupCreationScreen(genGroupController,
                friendsController, testProfile);
        screens.add(generalGroupCreationScreen, "Welcome!");
        cardLayout.show(screens, "create");
        application.pack();
        application.setVisible(true);

    }
}
