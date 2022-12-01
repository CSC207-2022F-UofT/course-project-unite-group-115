package general_group.screens;

import general_group.interface_adapters.GeneralGroupCreateController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GeneralGroupCreationScreen extends JPanel implements ActionListener {

    JTextField groupName = new JTextField(20);
    JButton getFriends = new JButton("Get friends");


    GeneralGroupCreateController controller;

    public GeneralGroupCreationScreen(GeneralGroupCreateController controller) {
        this.controller = controller;

        JLabel title = new JLabel("Custom group", SwingConstants.CENTER);

        LabelTextPanel groupNameInfo = new LabelTextPanel(
                new JLabel("Enter the name of your group:"), groupName);
        LabelButtonPanel getFriendsButton = new LabelButtonPanel(
                new JLabel("Select the friends you wish to create a custom group with (At most 7 friends):"), getFriends);

        JButton cancel = new JButton("Cancel");
        JButton enter = new JButton("Create group");

        JPanel bottomButtons = new JPanel();
        bottomButtons.add(enter);
        bottomButtons.add(cancel);


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(groupNameInfo);
        this.add(getFriendsButton);
        this.add(bottomButtons);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String nameOfGroup = groupName.getText();

    }

}
