package screens;
import flManager.interface_adapters.flManPresenter;
import database_classes.ProfileManagerDataAccess;
import database_classes.ProfileRepoInt;
import database_classes.flManRepoInt;
import entities.FriendListFactory;
import flManager.application_business_rules.flManInputBoundary;
import flManager.application_business_rules.flManUseCaseInteractor;
import flManager.interface_adapters.flManController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FriendsLoggedInScreen extends JFrame implements ActionListener {
    /**
     * The username chosen by the user
     */
    JTextField username = new JTextField(15);
    /**
     * A window with a title and a JButton.
     */
    public FriendsLoggedInScreen() {

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

        if (evt.getActionCommand().equals("Friends")) {
            ProfileRepoInt profileData;
            flManRepoInt flManRepoInt;
            try {
                profileData = new ProfileManagerDataAccess("./profiles.csv");
            } catch (IOException e) {
                throw new RuntimeException("Could not create file.");
            }

            // friend list screen Creation
            JFrame friLstApplication = new JFrame("Friend List Screen");
            CardLayout friLstCardLayout = new CardLayout();
            JPanel friLstScreens = new JPanel(friLstCardLayout);
            friLstApplication.add(friLstScreens);

            // Parts for friend list Use Case
            flManPresenter flManPresenter = new flManPresenter();
            FriendListFactory flFactory = new FriendListFactory();

            flManInputBoundary flInteractor = new flManUseCaseInteractor(flManPresenter,
                    flFactory, profileData);
            flManController controller = new flManController(flInteractor);


            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            JFrame application = new flScreen(controller);
            application.pack();
            application.setVisible(true);
        }
    }

}
