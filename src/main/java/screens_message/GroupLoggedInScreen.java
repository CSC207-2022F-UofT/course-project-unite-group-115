package screens_message;

import databases_message.MessageFile;
import databases_message.MessageRepoInt;
import entity_message.MessageFactory;
import interface_adapters_message.ViewMessageController;
import interface_adapters_message.ViewMessagePresenter;
import use_case_message_send.MessageInputBoundary;
import use_case_message_send.MessageInteractor;
import interface_adapters_message.MessageController;
import interface_adapters_message.MessagePresenter;
import use_case_message_view.ViewMessageInputBoundary;
import use_case_message_view.ViewMessageInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class GroupLoggedInScreen extends JFrame implements ActionListener {

    String GroupID;  //TODO: reach group ID and Messagename by connect to the group class
    String loginUserName;

    public GroupLoggedInScreen(String groupId, String loginUserName) {
        this.GroupID = groupId;
        this.loginUserName = loginUserName;


        JLabel title = new JLabel(groupId);

//        String welcome1 = String.format("Welcome to group %1$s, %2$s" +
//                "Click send to type the content you want to send within the group " +
//                "Click view to check all the messages that other members sent " +
//                "Click back to return to Group chosen page ",
//                groupName, loginMessageName);
//
//        JLabel practise = new JLabel(welcome1);

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
//      main.add(practise);
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
                message = new MessageFile("./src/main/java/databases_message/messages.csv");
            } catch (IOException e) {
                throw new RuntimeException("Could not create file.");
            }
            MessagePresenter presenter = new MessagePresenter();
            MessageFactory messageFactory = new MessageFactory();
            MessageInputBoundary interactor = new MessageInteractor(
                    message, presenter, messageFactory);
            MessageController MessageController = new MessageController(interactor);

            //build GUI
            JFrame applicationMessage = new MessageScreen(GroupID, loginUserName, MessageController);
            applicationMessage.pack();
            applicationMessage.setVisible(true);

        } else if (evt.getActionCommand().equals("view")) {
            MessageRepoInt message;
            try {
                message = new MessageFile("./src/main/java/databases_message/messages.csv");
            } catch (IOException e) {
                throw new RuntimeException("Could not create file");
            }
            ViewMessagePresenter presenter = new ViewMessagePresenter();
            ViewMessageInputBoundary interactor = new ViewMessageInteractor(message, presenter);
            ViewMessageController ViewMessageController = new ViewMessageController(interactor);//may not needed
            ViewMessageController.create(GroupID);

            String messages = " " + String.format(ViewMessageController.create(GroupID).getPresented());
            messages = messages.replace("[","").replace("]","");
            messages = messages.replace(","," "); //this is an interesting feature called comma killer
            JOptionPane.showMessageDialog(this, messages);


        } else if (evt.getActionCommand().equals("back")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            JFrame applicationback = new GroupScreen();  //todo: add parameter
            applicationback.pack();
            applicationback.setVisible(true);
        }
    }
}