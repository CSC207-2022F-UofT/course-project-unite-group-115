package screens;

import database_classes.GroupRepoInt;
import database_classes.ProfileRepoInt;
import entities.GeneralGroupFactory;
import entities.RandomGroupFactory;
import use_cases.general_group.interface_adapters.GeneralGroupCreateController;
import use_cases.general_group.interface_adapters.GeneralGroupCreatePresenter;
import use_cases.general_group.use_case.GeneralGroupCreateInteractor;
import use_cases.general_group.use_case.GeneralGroupCreateOutputBoundary;
import use_cases.get_friends.interface_adapters.GetFriendsController;
import use_cases.get_friends.interface_adapters.GetFriendsPresenter;
import use_cases.get_friends.use_case.GetFriendsInteractor;
import use_cases.get_friends.use_case.GetFriendsOutputBoundary;
import use_cases.get_groups.application_business_rules.GetGroupsInteractor;
import use_cases.get_groups.application_business_rules.GetGroupsResponseModel;
import use_cases.get_groups.interface_adapters.GetGroupsController;
import use_cases.get_groups.interface_adapters.GetGroupsPresenter;
import use_cases.random_grouper_create.application_business_rules.RanGroupCreateInputBoundary;
import use_cases.random_grouper_create.application_business_rules.RanGroupCreateInteractor;
import use_cases.random_grouper_create.application_business_rules.RanGroupCreateOutputBoundary;
import use_cases.random_grouper_create.interface_adapters.RanGroupCreateControl;
import use_cases.random_grouper_create.interface_adapters.RanGroupCreatePresenter;
import use_cases.random_grouper_request_group.application_business_rules.ReqRanGroupInputBoundary;
import use_cases.random_grouper_request_group.application_business_rules.ReqRanGroupInteractor;
import use_cases.random_grouper_request_group.application_business_rules.ReqRanGroupOutputBoundary;
import use_cases.get_user_interests.application_business_rules.GetUserInterestsInteractor;
import use_cases.get_user_interests.application_business_rules.GetUserInterestsOutputBoundary;
import use_cases.get_user_interests.interface_adapters.GetUserInterestsController;
import use_cases.get_user_interests.interface_adapters.GetUserInterestsPresenter;
import use_cases.random_grouper_request_group.interface_adapters.ReqRanGroupController;
import use_cases.random_grouper_request_group.interface_adapters.ReqRanGroupPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GroupScreen extends JFrame implements ActionListener {
    Map<String, String> userGroups;
    JComboBox<String> groupList = new JComboBox<>();
    String groupChosen;
    List<String> groupsChosen;
    String loggedInUser;
    GroupRepoInt groupData;
    ProfileRepoInt profileData;

    public GroupScreen(String username, GroupRepoInt groupDatabase, ProfileRepoInt profileDatabase) {
        this.loggedInUser = username;
        this.groupData = groupDatabase;
        this.profileData = profileDatabase;
        this.groupsChosen = new ArrayList<>();

        JLabel title = new JLabel("Groups Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel buttons = new JPanel();
        JTextField groupArea = new JTextField("Your current groups:");

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        main.add(title);
        main.add(groupArea);

        try {
            GetGroupsPresenter presenter = new GetGroupsPresenter();
            GetGroupsInteractor interactor = new GetGroupsInteractor(presenter, profileData, groupData);
            GetGroupsController controller = new GetGroupsController(interactor);
            GetGroupsResponseModel response = controller.getUsersGroups(username);

            this.userGroups = response.getGroups();
            List<String> groupNames = response.getGroupNames();

            String[] allGroups = new String[groupNames.size()];

            for(int i = 0; i < allGroups.length; i++) {
                allGroups[i] = groupNames.get(i);
            }
            groupList = new JComboBox<>(allGroups);
            JButton go = new JButton("Go to Group");
            buttons.add(go);
            go.addActionListener(this);

            main.add(groupList);
        }
        catch (RuntimeException e) {
            groupArea.setText("You aren't a member of any groups yet! See the buttons below to be" +
                    " added to a random group based on your interests, or create your own group to chat with your " +
                    "existing friends.");
        }
        groupArea.setEnabled(false);

        JButton requestRanGroup = new JButton("Request a Random Group");
        requestRanGroup.addActionListener(this);
        buttons.add(requestRanGroup);
        JButton createGroup = new JButton("Create a General Group");
        createGroup.addActionListener(this);
        buttons.add(createGroup);

        main.add(buttons);
        this.setContentPane(main);

        this.pack();
    }

    @Override
    public void actionPerformed(ActionEvent evt){
        System.out.println("Click " + evt.getActionCommand());
        if(evt.getSource() == groupList) {
            groupChosen = (String)groupList.getSelectedItem();}
        if (evt.getActionCommand().equals("Go to Group")) {
            groupChosen = (String) groupList.getSelectedItem();
            GroupLoggedInScreen groupLoggedInScreen = new GroupLoggedInScreen(userGroups.get(groupChosen), loggedInUser,
                    groupChosen);

            JFrame groupApplication = new JFrame("Group: " + groupChosen);
            groupApplication.setSize(200, 200);
            groupApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            CardLayout cardLayout = new CardLayout();
            JPanel screens = new JPanel(cardLayout);
            groupApplication.add(screens);

            screens.add(groupLoggedInScreen);
            cardLayout.show(screens, "group");
            groupApplication.pack();
            groupApplication.setVisible(true);
        }
        else if (evt.getActionCommand().equals("Request a Random Group")){
            // Random Group Creation Window Creation
            JFrame groupCreationApplication = new JFrame("Random Group Creation");
            CardLayout groupCreationCardLayout = new CardLayout();
            JPanel groupCreationScreens = new JPanel(groupCreationCardLayout);
            groupCreationApplication.add(groupCreationScreens);

            // Parts for Random Group Creation Use Case
            RanGroupCreateOutputBoundary ranGroupCreateOutputBoundary = new RanGroupCreatePresenter();
            RandomGroupFactory ranGroupFactory = new RandomGroupFactory();
            RanGroupCreateInputBoundary groupCreateInteractor = new RanGroupCreateInteractor(groupData,
                    ranGroupCreateOutputBoundary, ranGroupFactory, profileData);
            RanGroupCreateControl groupCreateController = new RanGroupCreateControl(groupCreateInteractor);

            GetUserInterestsOutputBoundary getUserInterestsOutputBoundary = new GetUserInterestsPresenter();
            GetUserInterestsInteractor getUserInterestsInteractor = new
                    GetUserInterestsInteractor(getUserInterestsOutputBoundary, profileData);
            GetUserInterestsController getUserInterestsController =
                    new GetUserInterestsController(getUserInterestsInteractor);

            // Create Random Group Creation Screen
            RandomGroupCreationScreen creationScreen = new RandomGroupCreationScreen(groupCreateController,
                    getUserInterestsController, loggedInUser);
            groupCreationScreens.add(creationScreen, "welcome");
            groupCreationCardLayout.show(groupCreationScreens, "create");
            groupCreationApplication.pack();

            // Create Request Random Group Window
            JFrame requestGroupApplication = new JFrame("Request Random Group");
            CardLayout requestGroupCardLayout = new CardLayout();
            JPanel requestGroupScreens = new JPanel(requestGroupCardLayout);
            requestGroupApplication.add(requestGroupScreens);

            // Create parts for Request Random Group Use Case
            ReqRanGroupOutputBoundary reqRanGroupOutputBoundary = new ReqRanGroupPresenter();
            ReqRanGroupInputBoundary reqRanGroupInteractor = new ReqRanGroupInteractor(groupData,
                    reqRanGroupOutputBoundary, profileData);
            ReqRanGroupController reqRanGroupController = new ReqRanGroupController(reqRanGroupInteractor);

            // Create and Display Request Random Group Screen
            RequestRandomGroupScreen reqGroupScreen = new RequestRandomGroupScreen(reqRanGroupController, groupCreationApplication,
                    loggedInUser);
            requestGroupScreens.add(reqGroupScreen, "welcome");
            requestGroupCardLayout.show(requestGroupScreens, "request");
            requestGroupApplication.pack();
            requestGroupApplication.setVisible(true);
        }
        else if (evt.getActionCommand().equals("Create a General Group")){
            JFrame generalGroupApplication = new JFrame("General Group Creation");
            generalGroupApplication.setSize(200, 200);
            generalGroupApplication.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            CardLayout cardLayout = new CardLayout();
            JPanel screens = new JPanel(cardLayout);
            generalGroupApplication.add(screens);

            GeneralGroupCreateOutputBoundary genGroupOutputBoundary = new GeneralGroupCreatePresenter();
            GeneralGroupFactory groupFactory = new GeneralGroupFactory();
            GeneralGroupCreateInteractor genGroupInteractor = new GeneralGroupCreateInteractor(groupData,
                    genGroupOutputBoundary, groupFactory, profileData);
            GeneralGroupCreateController genGroupController = new GeneralGroupCreateController(genGroupInteractor);

            GetFriendsOutputBoundary friendsOutputBoundary = new GetFriendsPresenter();
            GetFriendsInteractor friendsInteractor = new GetFriendsInteractor(friendsOutputBoundary, profileData);
            GetFriendsController friendsController = new GetFriendsController(friendsInteractor);

            GeneralGroupCreationScreen generalGroupCreationScreen = new GeneralGroupCreationScreen(genGroupController,
                    friendsController, loggedInUser, profileData);
            screens.add(generalGroupCreationScreen, "Welcome!");
            cardLayout.show(screens, "create");
            generalGroupApplication.pack();
            generalGroupApplication.setVisible(true);
        }
        }
        }
