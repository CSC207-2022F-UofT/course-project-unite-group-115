package screens;

import Databases.MessageFile;
import Databases.MessageRepoInt;
import Entity.MessageFactory;
import MessageUserCase.MessageInputBoundary;
import MessageUserCase.MessageInteractor;
import interface_adapters.MessageController;
import interface_adapters.MessagePresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class GroupLoggedInScreen extends JFrame implements ActionListener {

    String GroupName;  //TODO: reach group ID and username by connect to the group class
    String loginUserName;

    public GroupLoggedInScreen(String groupName, String loginUserName) {
        this.GroupName = groupName;
        this.loginUserName = loginUserName;


        JLabel title = new JLabel(groupName);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton send = new JButton("send");
        JButton view = new JButton("view");
        JButton back = new JButton("back");   //TODO:return to previous page

        JPanel buttons = new JPanel();
        buttons.add(send);
        buttons.add(view);
        buttons.add(back);

        send.addActionListener(this);
        view.addActionListener(this);
        back.addActionListener(this);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));  //?

        main.add(title);
        main.add(buttons);
        this.setContentPane(main);
        this.pack();
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        if (evt.getActionCommand().equals("send")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();

            // open the group window
            JFrame application = new JFrame("Group Name");  // TODO: CHANGE TO group name INPUT
            CardLayout cardLayout = new CardLayout();
            JPanel screens = new JPanel(cardLayout);
            application.add(screens);

            //plug in message entity
            MessageRepoInt message;
            try {
                message = new MessageFile("./src/main/java/Databases/messages.csv");
            } catch (IOException e) {
                throw new RuntimeException("Could not create file.");
            }
            MessagePresenter presenter = new MessagePresenter();
            MessageFactory messageFactory = new MessageFactory();
            MessageInputBoundary interactor = new MessageInteractor(
                    message, presenter, messageFactory);
            MessageController MessageController = new MessageController(interactor);

            //build GUI
            JFrame applicationMessage = new MessageScreen(GroupName, loginUserName, MessageController);
            applicationMessage.pack();
            applicationMessage.setVisible(true);

        }
        //TODO: finish
//        if (evt.getActionCommand().equals("view")) {
//
//
//        } else if (evt.getActionCommand().equals("back")) {
//            JComponent component = (JComponent) evt.getSource();
//            Window win = SwingUtilities.getWindowAncestor(component);
//            win.dispose();
//            JFrame applicationback = new GroupScreen();
//            applicationback.pack();
//            applicationback.setVisible(true);
//        }
    }
}