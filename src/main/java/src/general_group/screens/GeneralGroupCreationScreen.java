package general_group.screens;

import general_group.entities.User;
import general_group.interface_adapters.GeneralGroupCreateController;
import general_group.use_case.GeneralGroupCreateDsResponseModel;
import get_friends.entities.Profile;
import get_friends.interface_adapters.GetFriendsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GeneralGroupCreationScreen extends JPanel implements ActionListener  {

    JTextField groupName = new JTextField(20);
    JButton getFriends = new JButton("Choose friends");
    List<User> friendsChosen = new ArrayList<>();
    Profile creatorProfile;
    List<String> friendsChosenString = new ArrayList<>();
    GeneralGroupCreateController genGroupCreateController;
    GetFriendsController getFriendsController;


    public GeneralGroupCreationScreen(GeneralGroupCreateController genGroupCreateController,
                                      GetFriendsController friendsController) {
        this.genGroupCreateController = genGroupCreateController;
        this.getFriendsController = friendsController;


        JLabel title = new JLabel("Custom group", SwingConstants.CENTER);

        LabelTextPanel groupNameInfo = new LabelTextPanel(
                new JLabel("Enter the name of your group:"), groupName);
        LabelButtonPanel getFriendsButton = new LabelButtonPanel(
                new JLabel("Select the friends you wish to create a custom group with (At most 7 friends):"), getFriends);

        //For testing purposes only
        List<String> friendList = new ArrayList<>();
        friendList.add("a");
        friendList.add("b");
        friendList.add("C");
        creatorProfile = new Profile("AA", friendList);

        JButton cancel = new JButton("Cancel");
        JButton enter = new JButton("Create group");

        JPanel bottomButtons = new JPanel();
        bottomButtons.add(enter);
        bottomButtons.add(cancel);

        getFriends.addActionListener(this);
        cancel.addActionListener(this);
        enter.addActionListener(this);


        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(groupNameInfo);
        this.add(getFriendsButton);
        this.add(bottomButtons);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        if (evt.getActionCommand().equals("Cancel")) {
            System.exit(0);
        }
        else if (evt.getActionCommand().equals("Create group")) {
            try {
                GeneralGroupCreateDsResponseModel response = genGroupCreateController.create(groupName.getText(),
                        friendsChosen, creatorProfile.getUserName());
                JOptionPane.showMessageDialog(this, String.format("%s created at %s",
                        groupName.getText(), response.getCreationTime()));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }

        } else if (evt.getActionCommand().equals("Choose friends")){

            JFrame friendsApp = new JFrame("Choose a friend.");
            friendsApp.setSize(300, 100);
            CardLayout cardLayout = new CardLayout();
            JPanel screens = new JPanel(cardLayout);
            friendsApp.add(screens, BorderLayout.CENTER);

            AddingFriendsScreen addingFriendsScreen = new AddingFriendsScreen(getFriendsController, friendsChosenString);

            screens.add(addingFriendsScreen, "Welcome!");
            cardLayout.show(screens, "create");
            friendsApp.setVisible(true);
        }

    }

}