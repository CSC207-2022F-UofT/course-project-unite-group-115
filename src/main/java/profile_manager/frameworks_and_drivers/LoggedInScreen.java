package profile_manager.frameworks_and_drivers;

import entities.ProfileFactory;
import profile_manager.application_business_rules.ProfileManagerInputBoundary;
import profile_manager.application_business_rules.ProfileManagerInteractor;
import profile_manager.application_business_rules.ProfileRepoInt;
import profile_manager.interface_adapters.ProfileManagerController;
import profile_manager.interface_adapters.ProfileManagerPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

// Frameworks/Drivers layer

public class LoggedInScreen extends JFrame implements ActionListener {
    String  loginUserName;
    public LoggedInScreen(String userName) {

        this. loginUserName = userName;

        JLabel title = new JLabel("Logged-in Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton logOut = new JButton("Log out");
        JButton profile = new JButton("Profile");
        JButton chats = new JButton("Chats");
        JButton friends = new JButton("Friends");
        JButton groups = new JButton("Groups");

        JPanel buttons = new JPanel();
        buttons.add(logOut);
        buttons.add(profile);
        buttons.add(chats);
        buttons.add(friends);
        buttons.add(groups);
//        buttons.add(changePassword);

        logOut.addActionListener(this);
        profile.addActionListener(this);
        chats.addActionListener(this);
        friends.addActionListener(this);
        groups.addActionListener(this);
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
        if (evt.getActionCommand().equals("Profile")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();

            JFrame application = new JFrame("Profile Example");
            CardLayout cardLayout = new CardLayout();
            JPanel screens = new JPanel(cardLayout);
            application.add(screens);

            //         Create the parts to plug into the Use Case+Entities engine
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
            JFrame applicationProfile = new ProfileScreen(ProfileManagerController,  loginUserName);
            applicationProfile.pack();
            applicationProfile.setVisible(true);
        } else if (evt.getActionCommand().equals("Log out")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            JFrame application3 = new LoginScreen();
            application3.pack();
            application3.setVisible(true);
        }
    }
}
