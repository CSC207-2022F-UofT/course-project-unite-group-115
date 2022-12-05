package general_group.screens;

import get_friends.entities.ProfileFactory;
import get_friends.entities.Profile;
import get_friends.interface_adapters.GetFriendsController;
import get_friends.use_case.GetFriendsDsResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddingFriendsScreen extends JPanel implements ActionListener {

    JComboBox<String> cmbFriendList = new JComboBox<>();
    Profile creatorProfile;
    List<String> friendsChosen;
    GetFriendsController getFriendsController;
    String friendChosen;
    public AddingFriendsScreen(GetFriendsController controller, List<String> friendsChosen, Profile creatorProfile) {
        this.getFriendsController = controller;
        this.friendsChosen = friendsChosen;
        this.creatorProfile = creatorProfile;

        GetFriendsDsResponseModel response = getFriendsController.getFriendsList(creatorProfile);
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
