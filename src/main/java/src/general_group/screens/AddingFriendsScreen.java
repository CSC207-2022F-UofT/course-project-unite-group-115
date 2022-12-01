package general_group.screens;

import get_friends.entities.Profile;
import get_friends.interface_adapters.GetFriendsController;
import get_friends.use_case.GetFriendsDsResponseModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class AddingFriendsScreen extends JPanel implements ActionListener {

    JComboBox<String> cmbFriendList;
    Profile creatorProfile;
    List<String> allFriendsChosen;
    GetFriendsController getFriendsController;
    public AddingFriendsScreen(GetFriendsController controller, List<String> allFriendsChosen) {
        this.getFriendsController = controller;
        this.allFriendsChosen = allFriendsChosen;

        //Testing with a random profile, must change later on
        List<String> friendList = new ArrayList<>();
        friendList.add("a");
        friendList.add("b");
        friendList.add("C");
        creatorProfile = new Profile("AA", friendList);
        GetFriendsDsResponseModel response = getFriendsController.getFriendsList(creatorProfile);
        List<String> friendsList = new ArrayList<String>(response.getFriendList());

        JLabel title = new JLabel("Friend's list", SwingConstants.CENTER);

        String[] allFriends = new String[friendsList.size()];

        for(int i = 0; i < allFriends.length; i++) {
            allFriends[i] = friendsList.get(i);
        }
        cmbFriendList = new JComboBox<>(allFriends);
        JButton add = new JButton("Add");

        JPanel bottomButtons = new JPanel();
        bottomButtons.add(add);

        add.addActionListener(this);
        cmbFriendList.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(add);
        this.add(cmbFriendList);
    }
    @Override
    public void actionPerformed(ActionEvent evt) {
        if(evt.getSource() == cmbFriendList) {
            String friendChosen = (String)cmbFriendList.getSelectedItem();

            if(evt.getActionCommand().equals("Add") && !(allFriendsChosen.contains(friendChosen))) {
                allFriendsChosen.add(friendChosen);



            }
        }
    }
}
