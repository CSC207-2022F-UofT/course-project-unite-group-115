package screens;

import use_cases.add_friend.application_business_rules.AddFriendResponseModel;
import database_classes.ProfileManagerDataAccess;
import database_classes.ProfileRepoInt;
import use_cases.add_friend.application_business_rules.AddFriendInteractor;
import use_cases.add_friend.application_business_rules.AddFriendOutputBoundary;
import use_cases.add_friend.interface_adapter.AddFriendController;
import use_cases.add_friend.interface_adapter.AddFriendPresenter;
import use_cases.delete_friend.application_business_rules.DeleteFriendInteractor;
import use_cases.delete_friend.application_business_rules.DeleteFriendOutputBoundary;
import use_cases.delete_friend.application_business_rules.DeleteFriendResponseModel;
import use_cases.delete_friend.interface_adapter.DeleteFriendController;
import use_cases.delete_friend.interface_adapter.DeleteFriendPresenter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class FriendsScreen extends JFrame implements ActionListener {
    private String loggedInUser;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    public String ownerName = "";
    JTextField owner = new JTextField(15);
    JTextField userName = new JTextField(15);

    public FriendsScreen(String loggedInUser){
        this.loggedInUser = loggedInUser;
        JLabel title = new JLabel("Friend List");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(260, 70, 500, 600);
        contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(title);

        JLabel lblNewLabel = new JLabel("Enter the name of the user whose friends you would like to view: ");
        lblNewLabel.setBounds(15, 35, 370, 25);
        lblNewLabel.setSize(370,25);
        contentPane.add(lblNewLabel);

        textField = new JTextField();// owner name input
        textField.setHorizontalAlignment(SwingConstants.LEFT);
        textField.setColumns(10);
        textField.setBounds(15, 65, 66, 21);
        contentPane.add(textField);

        JLabel lblUserId = new JLabel("Friend's Username:");
        lblUserId.setBounds(15, 105, 370, 25);
        lblUserId.setSize(370,25);
        contentPane.add(lblUserId);

        textField_1 = new JTextField();// Username input
        textField_1.setColumns(10);
        textField_1.setBounds(15, 135, 66, 21);
        contentPane.add(textField_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(15, 220, 370, 270);
        contentPane.add(scrollPane);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(15, 220, 370, 270);
        textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        textArea.setRows(100);
        scrollPane.setViewportView(textArea);
        // can add the scrollPane to the textArea.

        JButton viewbtn = new JButton("View Friend List");
        viewbtn.setBounds(158, 65, 127, 23);


        viewbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // initialize
                try {
                    textArea.setText(null);

                    final Map<String, Integer> headers = new LinkedHashMap<>();
                    headers.put("userName", 0);
                    headers.put("friends", 8);

                    List<String> fl = null;

                    BufferedReader reader = new BufferedReader(new FileReader("./src/main/java/databases/profiles.csv"));
                    reader.readLine(); // skip header
                    String row;

                    if (textField.getText().trim().equals("")){
                        JOptionPane.showMessageDialog(contentPane,
                                (Object) "Please input the right info!", "Play",
                                JOptionPane.INFORMATION_MESSAGE);
                    } else {

                        while ((row = reader.readLine()) != null) {
                            String[] col = row.split(",");

                            if (Objects.equals(String.valueOf(col[headers.get("userName")]), textField.getText())) {
                                ownerName = textField.getText();
                                fl = Arrays.asList(String.valueOf(col[headers.get("friends")]).split(";"));

                                if (Objects.equals(fl.toString(), "")) {
                                    JOptionPane.showMessageDialog(contentPane,
                                            (Object) "There are no friends to display so far!\n", "Play",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    System.out.println("no user displayed");
                                    // display notice
                                } else {
                                    textArea.append(textField.getText() + " has " +
                                            fl.size() + " friends right now! \n");
                                    textArea.append("Friend List: \n");
                                    for (String fri : fl) {
                                        textArea.append(fri + "\n");
                                    }
                                    // Iterate usList and display user info line by line
                                    System.out.println("user displayed");
                                }

                            } else {
//                                JOptionPane.showMessageDialog(contentPane,
//                                        (Object) "There is no such a user \n", "Play",
//                                        JOptionPane.INFORMATION_MESSAGE);
                                System.out.println("no user displayed");
                                // display notice

                            }
                        }
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }

        });
        contentPane.add(viewbtn);

        JButton delbtn = new JButton("Delete Friend");
        delbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
//                    textArea.setText(null);
                    ProfileRepoInt profileData = new ProfileManagerDataAccess("./src/main/java/databases/profiles.csv");
                    DeleteFriendOutputBoundary presenter = new DeleteFriendPresenter();
                    DeleteFriendInteractor interactor = new DeleteFriendInteractor(profileData, presenter);
                    DeleteFriendController controller = new DeleteFriendController(interactor);
                    String friendUserName = textField_1.getText();
                    DeleteFriendResponseModel responseModel = presenter.prepareSuccessView(controller.deleteFriend(loggedInUser, friendUserName));
                    JOptionPane.showMessageDialog(contentPane, responseModel.getMessage());
                } catch (Exception e2) {
                    JOptionPane.showMessageDialog(contentPane, e2.getMessage());
                }
            }
        });
        delbtn.setBounds(258, 135, 117, 23);
        contentPane.add(delbtn);

        JButton addbtn = new JButton("Add Friend");
        addbtn.setHorizontalAlignment(SwingConstants.RIGHT);
        addbtn.setBounds(158, 135, 97, 23);

        addbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ProfileRepoInt profileData = new ProfileManagerDataAccess("./src/main/java/databases/profiles.csv");
                    AddFriendOutputBoundary presenter = new AddFriendPresenter();
                    AddFriendInteractor interactor = new AddFriendInteractor(profileData, presenter);
                    AddFriendController controller = new AddFriendController(interactor);
                    String friendUserName = textField_1.getText();
                    AddFriendResponseModel response = presenter.prepareSuccessView(controller.addFriend(loggedInUser, friendUserName));
                    JOptionPane.showMessageDialog(contentPane, response.getMessage());
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(contentPane, ex.getMessage());
                }
            }
        });
        contentPane.add(addbtn);

        JButton back = new JButton("Back");
        back.setBounds(315, 500, 70, 23);
        contentPane.add(back);
        back.addActionListener(this);

        JButton msg = new JButton("Send Message");
        msg.setBounds(15, 160, 120, 23);
        contentPane.add(msg);
        msg.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());
        if (e.getActionCommand().equals("Back")) {
            JComponent component = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            JFrame application2 = new LoggedInScreen(loggedInUser);
            application2.pack();
            application2.setVisible(true);
        } else if (e.getActionCommand().equals("Send Message")) {
            JOptionPane.showMessageDialog(contentPane,
                    (Object) "Feature in the future...", "Play",
                    JOptionPane.INFORMATION_MESSAGE);
            System.out.println("Feature in the future...");
            // display notice
        }

    }
}
