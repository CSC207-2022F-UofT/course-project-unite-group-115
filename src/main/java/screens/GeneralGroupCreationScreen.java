package screens;

import database_classes.ProfileRepoInt;
import use_cases.general_group.interface_adapters.GeneralGroupCreateController;
import use_cases.general_group.use_case.GeneralGroupCreateDsResponseModel;
import use_cases.get_friends.interface_adapters.GetFriendsController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class GeneralGroupCreationScreen extends JPanel implements ActionListener  {

    JTextField groupName = new JTextField(20);
    JButton getFriends = new JButton("Choose friends");
    List<String> friendsChosen = new ArrayList<>();
    ProfileRepoInt profileDatabase;
    GeneralGroupCreateController genGroupCreateController;
    GetFriendsController getFriendsController;
    String loggedInUser;

    public GeneralGroupCreationScreen(GeneralGroupCreateController genGroupCreateController,
                                      GetFriendsController friendsController, String username,
                                      ProfileRepoInt profileDatabase) {
        this.genGroupCreateController = genGroupCreateController;
        this.getFriendsController = friendsController;
        this.profileDatabase = profileDatabase;
        this.loggedInUser = username;


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
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
        }
        else if (evt.getActionCommand().equals("Create group")) {
            try {
                GeneralGroupCreateDsResponseModel response = genGroupCreateController.create(groupName.getText(),
                        friendsChosen, loggedInUser);
                JOptionPane.showMessageDialog(this, String.format("%s created at %s",
                        groupName.getText(), response.getCreationTime()));

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
                friendsChosen.clear();
            }

        } else if (evt.getActionCommand().equals("Choose friends")){

            JFrame friendsApp = new JFrame("Choose a friend.");
            friendsApp.setSize(300, 100);
            CardLayout cardLayout = new CardLayout();
            JPanel screens = new JPanel(cardLayout);
            friendsApp.add(screens, BorderLayout.CENTER);

            AddingFriendsToGroupScreen addingFriendsToGroupScreen = new AddingFriendsToGroupScreen(getFriendsController,
                    friendsChosen, profileDatabase, loggedInUser);

            screens.add(addingFriendsToGroupScreen, "Welcome!");
            cardLayout.show(screens, "create");
            friendsApp.setVisible(true);
        }

    }

}