package flManager.flFrame_Drivers;

import Entities.FriendList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class flPanel extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;

    public flPanel(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // TODO: 调整？？？？？没惹
        setBounds(300, 100, 600, 1200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Name: ");
        lblNewLabel.setBounds(10, 36, 58, 15);
        contentPane.add(lblNewLabel);

        JLabel lblUserId = new JLabel("Username");
        lblUserId.setBounds(10, 69, 58, 15);
        contentPane.add(lblUserId);

        textField = new JTextField();// Username input
        textField.setHorizontalAlignment(SwingConstants.LEFT);
        textField.setBounds(78, 66, 66, 21);
        contentPane.add(textField);
        textField.setColumns(10);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(306, 109, 540, 307);
        contentPane.add(scrollPane);

        JTextArea textArea = new JTextArea();
        textArea.setBounds(306, 109, 540, 307);
        textArea.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);// 自左到右的展示
        textArea.setRows(100);
        scrollPane.setViewportView(textArea);
        // can add the scrollPane to the textArea.

// TODO:finish implementing JButton and related functions
        JButton btnNewButton = new JButton("View Friend List");
        btnNewButton.setBounds(78, 29, 127, 23);
        /*
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // initialize
                try {
                    textArea.setText(null);
                    FriendList[] usList = admin.viewUserToWin();
                    if(usList == (null) || usList.length == 0) {
                        JOptionPane.showMessageDialog(contentPane,
                                (Object) "There is no user to display so far!\n", "Play",
                                JOptionPane.INFORMATION_MESSAGE);
                        System.out.println("no user displayed");
                        // display notice
                    } else {
                        textArea.append("There are " + usList.length + " users right now! \n");
                        textArea.append("User List: \n");
                        for(FriendList user:usList) {
                            textArea.append("\n" + user+"\n");
                        }
                        // Iterate usList and display user info line by line
                        System.out.println("user displayed");
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        });

         */
        contentPane.add(btnNewButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
