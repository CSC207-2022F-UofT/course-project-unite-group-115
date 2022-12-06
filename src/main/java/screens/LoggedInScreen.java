package screens;

import database_classes.GroupDataAccess;
import database_classes.GroupRepoInt;
import database_classes.ProfileManagerDataAccess;
import database_classes.ProfileRepoInt;
import entities.RandomGroupFactory;
import random_grouper_create.application_business_rules.RanGroupCreateInputBoundary;
import random_grouper_create.application_business_rules.RanGroupCreateInteractor;
import random_grouper_create.application_business_rules.RanGroupCreateOutputBoundary;
import random_grouper_create.interface_adapters.RanGroupCreateControl;
import random_grouper_create.interface_adapters.RanGroupCreatePresenter;
import random_grouper_request_group.application_business_rules.ReqRanGroupDataAccessInt;
import random_grouper_request_group.application_business_rules.ReqRanGroupInputBoundary;
import random_grouper_request_group.application_business_rules.ReqRanGroupInteractor;
import random_grouper_request_group.application_business_rules.ReqRanGroupOutputBoundary;
import random_grouper_request_group.get_user_interests.application_business_rules.GetUserInterestsInteractor;
import random_grouper_request_group.get_user_interests.application_business_rules.GetUserInterestsOutputBoundary;
import random_grouper_request_group.get_user_interests.interface_adapters.GetUserInterestsController;
import random_grouper_request_group.get_user_interests.interface_adapters.GetUserInterestsPresenter;
import random_grouper_request_group.interface_adapters.ReqRanGroupController;
import random_grouper_request_group.interface_adapters.ReqRanGroupPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// Frameworks/Drivers layer

public class LoggedInScreen extends JFrame implements ActionListener {
    /**
     * The username chosen by the user
     */
    JTextField username = new JTextField(15);
    /**
     * A window with a title and a JButton.
     */
    public LoggedInScreen() {

        JLabel title = new JLabel("Logged-in Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton logOut = new JButton("Log out");
        JButton profile = new JButton("Profile");
        JButton chats = new JButton("Chats");
        JButton friends = new JButton("Friends");
        JButton groups = new JButton("Groups");
        JButton report = new JButton("Report");
//        JButton changePassword = new JButton("Change password");
//
//        LabelTextPanel usernameInfo = new LabelTextPanel(
//                new JLabel("Username"), username);
//        username.setEditable(false);

        JPanel buttons = new JPanel();
        buttons.add(logOut);
        buttons.add(profile);
        // To Do: can remove this button - this is part of the groups screen now
        buttons.add(chats);
        buttons.add(friends);
        buttons.add(groups);
        buttons.add(report);
//        buttons.add(changePassword);

        logOut.addActionListener(this);
        profile.addActionListener(this);
        chats.addActionListener(this);
        friends.addActionListener(this);
        groups.addActionListener(this);
        report.addActionListener(this);
//        changePassword.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
//        main.add(usernameInfo);
        main.add(buttons);

        this.setContentPane(main);
        this.pack();
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        if (evt.getActionCommand().equals("Log out")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            JFrame application3 = new LoginScreen();
            application3.pack();
            application3.setVisible(true);
        }
        else if (evt.getActionCommand().equals("Groups")){
            // ToDo: need logged in user's username
            String loggedInUser = "ashley";
            GroupDataAccess groupData;
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
            JFrame application4 = new GroupScreen(loggedInUser, groupData, profileData);
            application4.pack();
            application4.setVisible(true);
        }
        }
    }
