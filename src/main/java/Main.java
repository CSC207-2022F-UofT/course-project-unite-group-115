import screens.*;
import javax.swing.*;

public class Main {
    /**
     * The main function (which is executed foremost) having call to
     * the WelcomeScreen, the first screen of the app.
     */
    public static void main(String[] args) {
        JFrame application2 = new WelcomeScreen();
        application2.pack();
        application2.setVisible(true);

    }
}
