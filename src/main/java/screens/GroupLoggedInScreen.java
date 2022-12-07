package screens;

import database_classes.MessageDataAccess;
import database_classes.MessageRepoInt;
import entities.MessageFactory;
import message_view.interface_adaptor.ViewMessageController;
import message_view.interface_adaptor.ViewMessagePresenter;
import message_send.application_business_rule.MessageInputBoundary;
import message_send.application_business_rule.MessageInteractor;
import message_send.interface_adaptor.MessageController;
import message_send.interface_adaptor.MessagePresenter;
import message_view.application_business_rule.ViewMessageInputBoundary;
import message_view.application_business_rule.ViewMessageInteractor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class GroupLoggedInScreen extends JPanel implements ActionListener {

    String GroupID;
    String loginUserName;
    String groupName;

    public GroupLoggedInScreen(String groupId, String loginUserName, String groupName) {
        this.GroupID = groupId;
        this.loginUserName = loginUserName;
        //ToDo: this line does not work for me
       /* this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);*/
        this.groupName = groupName;


        String welcome = String.format("Welcome to group %1$s! " +
                "Click send to type the content you want to send within the group. " +
                "Click view to check all the messages that other members sent. " +
                "Click back to return to Group selection page. ",
                groupName);

        JLabel title = new JLabel(welcome);

        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        JButton send = new JButton("send");
        JButton view = new JButton("view");
        JButton back = new JButton("back");

        JPanel buttons = new JPanel();
        buttons.add(send);
        buttons.add(view);
        buttons.add(back);

        send.addActionListener(this);
        view.addActionListener(this);
        back.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(buttons);
    }

    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        // Plug in message entity
        MessageRepoInt message;
        try {
            message = new MessageDataAccess("./src/main/java/databases/messages.csv");
        } catch (IOException e) {
            throw new RuntimeException("Could not create file.");
        }
        if (evt.getActionCommand().equals("send")) {
            // open the group window
            JFrame application = new JFrame(groupName);
            CardLayout cardLayout = new CardLayout();
            JPanel screens = new JPanel(cardLayout);
            application.add(screens);

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
            ViewMessagePresenter presenter = new ViewMessagePresenter();
            ViewMessageInputBoundary interactor = new ViewMessageInteractor(message, presenter);
            ViewMessageController viewMessageController = new ViewMessageController(interactor);//may not needed

            try {
                viewMessageController.create(GroupID, loginUserName);
                String messages = " " + String.format(ViewMessageController.create(GroupID,loginUserName).getPresented());
                messages = messages.replace("[","").replace("]","");
                messages = messages.replace(","," "); //this is an interesting feature called comma killer

                JFrame messageView = new MessagesView(message, messages, GroupID, loginUserName);
                messageView.pack();
                messageView.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }


        } else if (evt.getActionCommand().equals("back")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
        }
    }
}