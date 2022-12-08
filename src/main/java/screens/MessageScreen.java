package screens;

import message_send.interface_adaptor.MessageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;


public class MessageScreen extends JFrame implements ActionListener {
    JTextField messagecontent = new JTextField(30);
    String groupName;  //TODO: reach group ID and Messagename by connect to the group class
    String loginUserName;
    MessageController messageController;

    public MessageScreen(String groupName, String loginUserName, MessageController messageController) {
        this.messageController = messageController;
        this.groupName = groupName;
        this.loginUserName = loginUserName;

        LabelTextPanel content = new LabelTextPanel(new JLabel("content"), messagecontent);

        JButton send = new JButton("Send");
        JPanel buttons = new JPanel();
        buttons.add(send);


        send.addActionListener(this);
        JPanel main = new JPanel();
        main.add(send);
        main.add(content);
        this.setContentPane(main);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        if (evt.getActionCommand().equals("Send")) {
            try {
                messageController.create(messagecontent.getText(), loginUserName, groupName);
                JOptionPane.showMessageDialog(this, String.format("Message sent successfully to: %s", groupName));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        }

    }
}
