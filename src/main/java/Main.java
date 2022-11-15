import user_register.frameworks_and_drivers.*;
import user_register.application_business_rules.UserRegisterInputBoundary;
import user_register.interface_adapters.UserRegisterController;
import user_register.interface_adapters.UserRegisterPresenter;
import user_register.application_business_rules.UserRepoInt;
import user_register.application_business_rules.UserRegisterInteractor;
import entities.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        // Build the main program window
        JFrame application = new JFrame("Login Example");
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

        // Create the parts to plug into the Use Case+Entities engine
        UserRepoInt user;
        try {
            user = new UserDataAccess("./users.csv");
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

        // Build the GUI, plugging in the parts
        RegisterScreen registerScreen = new RegisterScreen(userRegisterController);
        screens.add(registerScreen, "welcome");
        cardLayout.show(screens, "register");
        application.pack();
        application.setVisible(true);


        WelcomeScreen welcomeScreen = new WelcomeScreen();
        LoginScreen loginScreen = new LoginScreen();
        LoggedInScreen loggedInScreen = new LoggedInScreen();
        screens.add(welcomeScreen, "register");
        screens.add(loginScreen, "login");
        screens.add(loggedInScreen, "loggedIn");

    }

}
