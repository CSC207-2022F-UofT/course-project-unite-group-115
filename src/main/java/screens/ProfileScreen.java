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
        JTextField instructions = new JTextField("Below please enter the information you would like stored in your " +
                "profile. Please note that any existing information will be overwritten.");
        instructions.setEnabled(false);
        LabelTextPanel userNameInfo = new LabelTextPanel(
                new JLabel("UserName"), userName);
        LabelTextPanel profileNameInfo = new LabelTextPanel(
                new JLabel("Profile Name"), profileName);
        LabelTextPanel dobInfo = new LabelTextPanel(
                new JLabel("Date of Birth (format: YYYY-MM-DD)"), dob);
        LabelTextPanel descriptionInfo = new LabelTextPanel(
                new JLabel("Description"), description);
        LabelTextPanel socialLinksInfo = new LabelTextPanel(
                new JLabel("Social Links (separate links using a ;)"), socialLinks);
        LabelTextPanel sensitiveWordsInfo = new LabelTextPanel(
                new JLabel("Sensitive Words (separate words using a ;)"), sensitiveWords);
        LabelTextPanel interestsInfo = new LabelTextPanel(
                new JLabel("Interests (separate interests using a ;)"), interests);

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
        main.add(instructions);
        main.add(userNameInfo);
        main.add(profileNameInfo);
        main.add(dobInfo);
        main.add(descriptionInfo);
        main.add(socialLinksInfo);
        main.add(sensitiveWordsInfo);
        main.add(interestsInfo);

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
                        Arrays.asList(interests.getText().split(";")));
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

