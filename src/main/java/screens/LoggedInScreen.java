package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
//        JButton changePassword = new JButton("Change password");
//
//        LabelTextPanel usernameInfo = new LabelTextPanel(
//                new JLabel("Username"), username);
//        username.setEditable(false);

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
        if (evt.getActionCommand().equals("Log out")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            JFrame application3 = new LoginScreen();
            application3.pack();
            application3.setVisible(true);
        }
    }
}
