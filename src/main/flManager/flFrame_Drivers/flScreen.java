package flManager.flFrame_Drivers;
import flManager.interface_adapters.flManController;

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

public class flScreen extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;

    public String ownerName = "";
    JTextField owner = new JTextField(15);
    JTextField userName = new JTextField(15);

    public flScreen(flManController controller){
        JLabel title = new JLabel("Friend List");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setBounds(300, 100, 600, 1200);
        contentPane = new JPanel();

        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.add(title);

        JLabel lblNewLabel = new JLabel("Name: ");
        lblNewLabel.setBounds(10, 36, 58, 15);
        contentPane.add(lblNewLabel);

        textField = new JTextField();// owner name input
        textField.setHorizontalAlignment(SwingConstants.LEFT);
        textField.setColumns(10);
        textField.setBounds(78, 33, 66, 21);
        contentPane.add(textField);

        JLabel lblUserId = new JLabel("Username:");
        lblUserId.setBounds(10, 69, 88, 15);
        contentPane.add(lblUserId);

        textField_1 = new JTextField();// Username input
        textField_1.setColumns(10);
        textField_1.setBounds(78, 69, 66, 21);
        contentPane.add(textField_1);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(78, 150, 540, 307);
        contentPane.add(scrollPane);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(78, 150, 540, 307);
        textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);// from left to right to display
        textArea.setRows(100);
        scrollPane.setViewportView(textArea);
        // can add the scrollPane to the textArea.

        JButton viewbtn = new JButton("View Friend List");
        viewbtn.setBounds(158, 31, 127, 23);


        viewbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // initialize
                try {
                    textArea.setText(null);

                    final Map<String, Integer> headers = new LinkedHashMap<>();
                    headers.put("userName", 0);
                    headers.put("friends", 1);

                    List<String> fl;

                    BufferedReader reader = new BufferedReader(new FileReader("java.friends.csv"));
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
                                fl = Collections.singletonList(col[headers.get("friends")]);

                                if (Objects.equals(fl.toString(), "[]")) {
                                    JOptionPane.showMessageDialog(contentPane,
                                            (Object) "There is no user to display so far!\n", "Play",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    System.out.println("no user displayed");
                                    // display notice
                                } else {
                                    textArea.append(textField.getText() + " has " +
                                            fl.size() + " friends right now! \n");
                                    textArea.append("Friend List:");
                                    for (String fri : fl) {
                                        textArea.append("\n" + fri + "\n");
                                    }
                                    // Iterate usList and display user info line by line
                                    System.out.println("user displayed");
                                }

                            } else {
                                JOptionPane.showMessageDialog(contentPane,
                                        (Object) "There is no such a user \n", "Play",
                                        JOptionPane.INFORMATION_MESSAGE);
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
                    textArea.setText(null);
                    String owner = textField.getText();
                    String userName = textField_1.getText();
                    // get owner & username

                    if (owner.trim().equals("") || userName.trim().equals("")) {
                        JOptionPane.showMessageDialog(contentPane,
                                (Object) "Please input the right info!", "Play",
                                JOptionPane.INFORMATION_MESSAGE);
                        // display notice
                    } else {
                        final Map<String, Integer> headers = new LinkedHashMap<>();
                        headers.put("userName", 0);
                        headers.put("friends", 1);

                        List<String> fl;

                        BufferedReader reader = new BufferedReader(new FileReader("java.friends.csv"));
                        reader.readLine(); // skip header
                        String row;

                        while ((row = reader.readLine()) != null) {
                            String[] col = row.split(",");

                            if (Objects.equals(String.valueOf(col[headers.get("userName")]), owner)) {
                                fl = Collections.singletonList(col[headers.get("friends")]);

                                fl.remove(userName);
                                textArea.append("\t The user: " + userName + " is deleted! " + "\n");
                                // add new user and display
                            } else {
                                JOptionPane.showMessageDialog(contentPane,
                                        (Object) "User cannot found!", "Play",
                                        JOptionPane.INFORMATION_MESSAGE);
                                System.out.println("Wrong");
                                // display notice
                            }
                        }

                    }

                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });
        delbtn.setBounds(258, 67, 117, 23);
        contentPane.add(delbtn);

        JButton addbtn = new JButton("Add Friend");
        addbtn.setHorizontalAlignment(SwingConstants.RIGHT);
        addbtn.setBounds(158, 67, 97, 23);

        addbtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    textArea.setText(null);
                    String owner = textField.getText();
                    String userName = textField_1.getText();
                    // get owner & username
                    if (owner.trim().equals("") || userName.trim().equals("")) {
                        JOptionPane.showMessageDialog(contentPane,
                                (Object) "Please input the right info!", "Play",
                                JOptionPane.INFORMATION_MESSAGE);
                        // display notice
                    } else {
                        final Map<String, Integer> headers = new LinkedHashMap<>();
                        headers.put("userName", 0);
                        headers.put("friends", 1);

                        List<String> fl;

                        BufferedReader reader = new BufferedReader(new FileReader("java.friends.csv"));
                        reader.readLine(); // skip header
                        String row;

                        while ((row = reader.readLine()) != null) {
                            String[] col = row.split(",");

                            if (Objects.equals(String.valueOf(col[headers.get("userName")]), owner)) {
                                fl = Collections.singletonList(col[headers.get("friends")]);

                                fl.add(userName);
                                textArea.append("\t The user: " + userName + " is added! " + "\n");
                                // add new user and display
                            }
                        }
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        contentPane.add(addbtn);



        JButton back = new JButton("Back");
        back.setBounds(545, 485, 70, 23);
        contentPane.add(back);
        back.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Click " + e.getActionCommand());

        if (e.getActionCommand().equals("Back")) {
            JComponent component = (JComponent) e.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            JFrame application2 = new LoggedInScreen();
            application2.pack();
            application2.setVisible(true);
        }

    }
}
