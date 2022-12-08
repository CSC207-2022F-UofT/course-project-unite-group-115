package screens;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import database_classes.UserDataAccess;
import use_cases.user_register.application_business_rules.UserRegisterInputBoundary;
import use_cases.user_register.interface_adapters.UserRegisterController;
import use_cases.user_register.interface_adapters.UserRegisterPresenter;
import database_classes.UserRepoInt;
import use_cases.user_register.application_business_rules.UserRegisterInteractor;
import entities.*;

public class WelcomeScreen extends JFrame implements ActionListener {

    /**
     * A window with buttons to navigate to sign up or to login.
     */
    public WelcomeScreen() {

        JLabel title = new JLabel("Welcome Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        JButton logIn = new JButton("Log in");
        JButton signUp = new JButton("Sign up");

        JPanel buttons = new JPanel();
        buttons.add(logIn);
        buttons.add(signUp);

        logIn.addActionListener(this);
        signUp.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));

        main.add(title);
        main.add(buttons);
        this.setContentPane(main);
        this.pack();
    }

    /**
     * React to a button click that results in evt.
     */
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        if (evt.getActionCommand().equals("Sign up")) {
        JComponent component = (JComponent) evt.getSource();
        Window win = SwingUtilities.getWindowAncestor(component);
        win.dispose();
                    // Build the main program window
        JFrame application = new JFrame("Login Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

//         Create the parts to plug into the Use Case+Entities engine
        UserRepoInt user;
        try {
            user = new UserDataAccess("./src/main/java/databases/users.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        UserRegisterPresenter presenter = new UserRegisterPresenter();
        UserFactory userFactory = new UserFactory();
        UserRegisterInputBoundary interactor = new UserRegisterInteractor(
                user, presenter, userFactory);
        UserRegisterController userRegisterController = new UserRegisterController(
                interactor
        );

//             Build the GUI, plugging in the parts

        RegisterScreen registerScreen = new RegisterScreen(userRegisterController);
        screens.add(registerScreen, "welcome");
        cardLayout.show(screens, "register");
        application.pack();
        application.setVisible(true);
        } else if (evt.getActionCommand().equals("Log in")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            JFrame application3 = new LoginScreen();
            application3.pack();
            application3.setVisible(true);
        } else if (evt.getActionCommand().equals("Cancel")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
        }
    }
}
