package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

// Frameworks/Drivers layer
public class LoginScreen extends JFrame implements ActionListener {
    /**
     * A temporary holder for the inputted username
     */
    public String userName = "";

    /**
     * The username chosen by the user
     */
    JTextField username = new JTextField(15);
    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);


    /**
     * A window with a options for a user to login by providing account credentials (username and password).
     */
    public LoginScreen() {

        JLabel title = new JLabel("Login Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel usernameInfo = new LabelTextPanel(
                new JLabel("Username"), username);
        LabelTextPanel passwordInfo = new LabelTextPanel(
                new JLabel("Password"), password);

        JButton logIn = new JButton("Log in");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(cancel);

        logIn.addActionListener(this);
        cancel.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(usernameInfo);
        main.add(passwordInfo);
        main.add(buttons);
        this.setContentPane(main);

        this.pack();
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        if (evt.getActionCommand().equals("Log in")) {
            try {
                final Map<String, Integer> headers = new LinkedHashMap<>();
                headers.put("userName", 0);
                headers.put("password", 1);
                headers.put("creationTime", 2);
                headers.put("profileName", 3);
                headers.put("dob", 4);
                headers.put("description", 5);
                headers.put("socialLinks", 6);
                headers.put("sensitiveWords", 7);
                headers.put("interests", 8);
                headers.put("groups", 9);
                headers.put("friends", 10);
                headers.put("blockedUsers", 11);

                BufferedReader reader = new BufferedReader(new FileReader("./src/main/java/databases/users.csv"));
                reader.readLine(); // skip header
                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    if (Objects.equals(String.valueOf(col[headers.get("userName")]), username.getText()) &
                            Objects.equals(String.valueOf(col[headers.get("password")]), password.getText())) {
                        userName = username.getText();
                        JComponent component = (JComponent) evt.getSource();
                        Window win = SwingUtilities.getWindowAncestor(component);
                        win.dispose();
                        JFrame application4 = new LoggedInScreen(userName);
                        application4.pack();
                        application4.setVisible(true);
                        JOptionPane.showMessageDialog(this, String.format("%s Logged In.", username.getText()));
                    }
                }
                if (Objects.equals(userName, "")) {
                    JOptionPane.showMessageDialog(this, String.format("User %s does not exist OR Incorrect Password", username.getText()));
                }
                reader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else if (evt.getActionCommand().equals("Cancel")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            JFrame application2 = new WelcomeScreen();
            application2.pack();
            application2.setVisible(true);
        }
    }
}
