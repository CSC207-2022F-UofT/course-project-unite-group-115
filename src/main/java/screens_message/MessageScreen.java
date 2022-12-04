package screens_message;

import interface_adapters_message.MessageController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;


public class MessageScreen extends JFrame implements ActionListener {
    JTextField messagecontent = new JTextField(30);
    String groupName;  //TODO: reach group ID and Messagename by connect to the group class
    String loginMessageName;
    MessageController messageController;

    public MessageScreen(String groupName, String loginMessageName, MessageController messageController) {
        this.messageController = messageController;
        this.groupName = groupName;
        this.loginMessageName = loginMessageName;

        LabelTextPanel content = new LabelTextPanel(new JLabel("content"), messagecontent);

        JButton send = new JButton("Send");
        JButton back = new JButton("back");
        JPanel buttons = new JPanel();
        buttons.add(send);
        buttons.add(back);

        send.addActionListener(this);
        //todo: set layout?
        JPanel main = new JPanel();
        main.add(send);
        main.add(back);
        main.add(content);
        this.setContentPane(main);
        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        if (evt.getActionCommand().equals("Send")) {
            try {
                messageController.create(messagecontent.getText(), loginMessageName, groupName);
                JOptionPane.showMessageDialog(this, String.format("Message sent successfully to: %s", groupName));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }else if (evt.getActionCommand().equals("back")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            JFrame applicationback = new GroupLoggedInScreen(groupName,loginMessageName);
            applicationback.pack();
            applicationback.setVisible(true);
        }

    }
}
