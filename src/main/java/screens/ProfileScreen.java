package screens;

import profile_manager.interface_adapters.ProfileManagerController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

public class ProfileScreen extends JFrame implements ActionListener {

    JTextField profileName = new JTextField(15);
    JTextField dob = new JTextField(15);
    JTextField description = new JTextField(15);
    JTextField socialLinks = new JTextField(15);
    JTextField sensitiveWords = new JTextField(15);
    JTextField interests = new JTextField(15);
    JTextField groups = new JTextField(15);
    JTextField friends = new JTextField(15);
    JTextField blockedUsers = new JTextField(15);
    ProfileManagerController profileManagerController;
    String loginUserName;


    /**
     * A window with a title and a JButton.
     */
    public ProfileScreen(ProfileManagerController controller, String  loginUserName) {

        this.profileManagerController = controller;
        this.loginUserName = loginUserName;

        JTextField userName = new JTextField(this.loginUserName,15);
        userName.setEnabled(false);

        JLabel title = new JLabel("Profile Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel userNameInfo = new LabelTextPanel(
                new JLabel("UserName"), userName);
        LabelTextPanel profileNameInfo = new LabelTextPanel(
                new JLabel("ProfileName"), profileName);
        LabelTextPanel dobInfo = new LabelTextPanel(
                new JLabel("DOB"), dob);
        LabelTextPanel descriptionInfo = new LabelTextPanel(
                new JLabel("Description"), description);
        LabelTextPanel socialLinksInfo = new LabelTextPanel(
                new JLabel("SocialLinks"), socialLinks);
        LabelTextPanel sensitiveWordsInfo = new LabelTextPanel(
                new JLabel("SensitiveWords"), sensitiveWords);
        LabelTextPanel interestsInfo = new LabelTextPanel(
                new JLabel("Interests"), interests);
        LabelTextPanel groupsInfo = new LabelTextPanel(
                new JLabel("Groups"), groups);
        LabelTextPanel friendsInfo = new LabelTextPanel(
                new JLabel("Friends"), friends);
        LabelTextPanel blockedUsersInfo = new LabelTextPanel(
                new JLabel("BlockedUsers"), blockedUsers);


        JButton update = new JButton("Update");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(update);
        buttons.add(cancel);

        update.addActionListener(this);
        cancel.addActionListener(this);


        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);

        main.add(userNameInfo);
        main.add(profileNameInfo);
        main.add(dobInfo);
        main.add(descriptionInfo);
        main.add(socialLinksInfo);
        main.add(sensitiveWordsInfo);
        main.add(interestsInfo);
        main.add(groupsInfo);
        main.add(friendsInfo);
        main.add(blockedUsersInfo);

        main.add(buttons);

        this.setContentPane(main);

        this.pack();
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        if (evt.getActionCommand().equals("Update")) {
            try {

                profileManagerController.create(
                        loginUserName,
                        profileName.getText(),
                        LocalDate.parse(dob.getText()),
                        description.getText(),
                        Arrays.asList(socialLinks.getText().split(";")),
                        Arrays.asList(sensitiveWords.getText().split(";")),
                        Arrays.asList(interests.getText().split(";")),
                        Arrays.asList(groups.getText().split(";")),
                        Arrays.asList(friends.getText().split(";")),
                        blockedUsers.getText());
//                        Arrays.asList(blockedUsers.getText().split(";")));
                JOptionPane.showMessageDialog(this, String.format("Updated Profile of User: %s", loginUserName));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else if (evt.getActionCommand().equals("Cancel")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            JFrame application2 = new LoggedInScreen(loginUserName);
            application2.pack();
            application2.setVisible(true);
        }
    }
}

