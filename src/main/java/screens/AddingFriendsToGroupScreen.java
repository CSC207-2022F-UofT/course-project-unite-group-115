package screens;

import database_classes.ProfileRepoInt;
import use_cases.get_friends.interface_adapters.GetFriendsController;
import use_cases.get_friends.use_case.GetFriendsDsResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddingFriendsToGroupScreen extends JPanel implements ActionListener {

    JComboBox<String> cmbFriendList = new JComboBox<>();
    ProfileRepoInt profileDatabase;
    String loggedInUser;
    List<String> friendsChosen;
    GetFriendsController getFriendsController;
    String friendChosen;
    public AddingFriendsToGroupScreen(GetFriendsController controller, List<String> friendsChosen,
                                      ProfileRepoInt profileDatabse, String username) {
        this.getFriendsController = controller;
        this.friendsChosen = friendsChosen;
        this.profileDatabase = profileDatabse;
        this.loggedInUser = username;


        GetFriendsDsResponseModel response = getFriendsController.getFriendsList(loggedInUser);
        List<String> friendsList = new ArrayList<>(response.getFriendList());

        JLabel title = new JLabel("Friend's list", SwingConstants.CENTER);

        String[] allFriends = new String[friendsList.size()];

        for(int i = 0; i < allFriends.length; i++) {
            allFriends[i] = friendsList.get(i);
        }

        cmbFriendList = new JComboBox<>(allFriends);
        JButton addFriend = new JButton("Add");

        JPanel bottomButtons = new JPanel();
        bottomButtons.add(addFriend);

        cmbFriendList.addActionListener(this);
        addFriend.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(addFriend);
        this.add(cmbFriendList);
    }
    @Override
    public void actionPerformed(ActionEvent evt) {

        if(evt.getSource() == cmbFriendList) {
            friendChosen = (String)cmbFriendList.getSelectedItem();
        }
        if(evt.getActionCommand().equals("Add")) {
            friendsChosen.add(friendChosen);
            JOptionPane.showMessageDialog(this, "Friend has been added.");
        }
    }
}
