package screens;

import database_classes.GroupDataAccess;
import database_classes.ProfileManagerDataAccess;
import database_classes.ProfileRepoInt;
import entities.ProfileFactory;
import use_cases.profile_manager.application_business_rules.ProfileManagerInputBoundary;
import use_cases.profile_manager.application_business_rules.ProfileManagerInteractor;
import use_cases.profile_manager.interface_adapters.ProfileManagerController;
import use_cases.profile_manager.interface_adapters.ProfileManagerPresenter;

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
    String username;
    /**
     * A window with a title and a JButton.
     */
    public LoggedInScreen(String username) {
        this.username = username;

        JLabel title = new JLabel("Logged-in Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton logOut = new JButton("Log out");
        JButton profile = new JButton("Profile");
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
        buttons.add(friends);
        buttons.add(groups);
        buttons.add(report);
//        buttons.add(changePassword);

        logOut.addActionListener(this);
        profile.addActionListener(this);
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
        else if (evt.getActionCommand().equals("Profile")){
            Component component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();

            JFrame application = new JFrame("Edit Profile");
            CardLayout cardLayout = new CardLayout();
            JPanel screens = new JPanel(cardLayout);
            application.add(screens);

            // Create the parts to plug into the Use Case+Entities engine
            ProfileRepoInt user;
            try {
                user = new ProfileManagerDataAccess("./src/main/java/databases/profiles.csv");
            } catch (IOException e) {
                throw new RuntimeException("Could not create file.");
            }
            ProfileManagerPresenter presenter = new ProfileManagerPresenter();
            ProfileFactory userFactory = new ProfileFactory();
            ProfileManagerInputBoundary interactor = new ProfileManagerInteractor(
                    user, presenter, userFactory);
            ProfileManagerController ProfileManagerController = new ProfileManagerController(
                    interactor
            );
            JFrame applicationProfile = new ProfileScreen(ProfileManagerController, username);
            applicationProfile.pack();
            applicationProfile.setVisible(true);
        }
        else if (evt.getActionCommand().equals("Friends")){
            ProfileRepoInt profileData;
            try {
                profileData = new ProfileManagerDataAccess("./src/main/java/databases/profiles.csv");
            } catch (IOException e) {
                throw new RuntimeException("Could not create file.");
            }

            // friend list screen Creation
            JFrame friLstApplication = new JFrame("Friend List Screen");
            CardLayout friLstCardLayout = new CardLayout();
            JPanel friLstScreens = new JPanel(friLstCardLayout);
            friLstApplication.add(friLstScreens);

            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            JFrame application = new FriendsScreen(username);
            application.setVisible(true);
        }
        else if (evt.getActionCommand().equals("Groups")){
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
            JFrame application4 = new GroupScreen(username, groupData, profileData);
            application4.pack();
            application4.setVisible(true);
        }
        else if (evt.getActionCommand().equals("Report")) {
            JFrame application2 = new ReportFirstScreen(username);
            application2.pack();
            application2.setVisible(true);
        }
        }

    }
