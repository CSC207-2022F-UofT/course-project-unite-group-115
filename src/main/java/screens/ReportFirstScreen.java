package screens;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

import database_classes.UserReporterInt;
import block_user_application.application_business_rules.UserReporterInputBoundary;
import block_user_application.application_business_rules.UserReporterInteractor;
import block_user_application.interface_adapters.UserReporterController;
import block_user_application.interface_adapters.UserReporterPresenter;
import entities.BlockerFactory;
import database_classes.UserreporterDataAccess;

public class ReportFirstScreen extends JFrame implements ActionListener {
    public ReportFirstScreen() {

        JLabel title = new JLabel("Report System");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton report = new JButton("Report User");
        JButton block = new JButton("Back");

        JPanel buttons = new JPanel();
        buttons.add(report);
        buttons.add(block);

        report.addActionListener(this);
        block.addActionListener(this);

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
        if (evt.getActionCommand().equals("Report User")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            // Build the main program window
            JFrame application = new JFrame("Report Example");
            CardLayout cardLayout = new CardLayout();
            JPanel screens = new JPanel(cardLayout);
            application.add(screens);

            UserReporterInt user;
            try {
                user = new UserreporterDataAccess("./src/main/java/databases/java.report.csv");
            } catch (IOException e) {
                throw new RuntimeException("Could not create file.");
            }
            UserReporterPresenter presenter = new UserReporterPresenter();
            BlockerFactory userFactory = new BlockerFactory();

            UserReporterInputBoundary interactor = new UserReporterInteractor(
                    user, presenter, userFactory);
            UserReporterController userReporterController = new UserReporterController(
                    interactor
            );


            SubmitReportScreen reportScreen = new SubmitReportScreen(userReporterController);
            screens.add(reportScreen, "welcome");
            cardLayout.show(screens, "register");
            application.pack();
            application.setVisible(true);
        }/*else if (evt.getActionCommand().equals("Back")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            JFrame application2 = new LoggedInScreen();
            application2.pack();
            application2.setVisible(true);
        }*/
    }
}
