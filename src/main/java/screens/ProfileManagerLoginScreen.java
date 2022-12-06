package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import static javax.swing.JOptionPane.showMessageDialog;

// Frameworks/Drivers layer
public class ProfileManagerLoginScreen extends JFrame implements ActionListener {
    public String loginUserName = "";
    /**
     * The username chosen by the user
     */
    JTextField username = new JTextField(15);
    /**
     * The password
     */
    JPasswordField password = new JPasswordField(15);


    /**
     * A window with a title and a JButton.
     */
    public ProfileManagerLoginScreen() {

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

                BufferedReader reader = new BufferedReader(new FileReader("./src/main/java/databases/users.csv"));
                reader.readLine(); // skip header
//                if ((reader.readLine()) == null) {
//                    JOptionPane.showMessageDialog(this, "No users in Database.");
//                }
                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    if (Objects.equals(String.valueOf(col[headers.get("userName")]), username.getText()) &
                            Objects.equals(String.valueOf(col[headers.get("password")]), password.getText())) {
                        loginUserName = username.getText();
                        JComponent component = (JComponent) evt.getSource();
                        Window win = SwingUtilities.getWindowAncestor(component);
                        win.dispose();
                        JFrame application4 = new ProfileManagerLoggedInScreen(loginUserName);
                        application4.pack();
                        application4.setVisible(true);
                        JOptionPane.showMessageDialog(this, String.format("%s Logged In.", username.getText()));
                    }
                }
                if (Objects.equals(loginUserName, "")) {
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
//            JFrame application2 = new WelcomeScreen();
//            application2.pack();
//            application2.setVisible(true);
        }
    }
}