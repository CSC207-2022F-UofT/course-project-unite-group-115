package screens;

import random_grouper_request_group.interface_adapters.ReqRanGroupController;
import random_grouper_request_group.interface_adapters.ReqRanGroupPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestRandomGroupScreen extends JPanel implements ActionListener {
    ReqRanGroupController reqRanGroupController;
    JFrame createRanGroupScreen;

    JTextArea instructions = new JTextArea("Click below to be added to a random group that best matches with your" +
            " interests!");

    String loggedInUserName;

    /**
     * Creates a window that allows a User to request to be added to a random group with the most interests in common
     * with them
     * @param controller the object that controls the attempt to add a User to a random group
     */
    public RequestRandomGroupScreen(ReqRanGroupController controller, JFrame createRanGroupScreen, String loggedInUserName) {
        this.reqRanGroupController = controller;
        this.createRanGroupScreen = createRanGroupScreen;
        this.loggedInUserName = loggedInUserName;

        JLabel title = new JLabel("Request Random Group");

        instructions.setEditable(false);

        JButton addToGroup = new JButton("Request Random Group");
        JButton createRandomGroup = new JButton("Create Random Group");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(addToGroup);
        buttons.add(createRandomGroup);
        buttons.add(cancel);

        addToGroup.addActionListener(this);
        createRandomGroup.addActionListener(this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(instructions);
        this.add(buttons);
    }

    /**
     * Invoked when a button is pressed and results in evt.
     *
     * @param evt the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

        if (evt.getActionCommand().equals("Request Random Group")) {
            try {
                ReqRanGroupPresenter presenter = new ReqRanGroupPresenter();

                String message = presenter.getSuccessMessage(reqRanGroupController.requestRanGroup(loggedInUserName));
                JOptionPane.showMessageDialog(this, message);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage() + " To create a random" +
                        " group based on your interests click the 'Create Random Group' button to create your own!");
        }
        } else if (evt.getActionCommand().equals("Create Random Group")) {
            createRanGroupScreen.setVisible(true);
        }
        else if (evt.getActionCommand().equals("Cancel")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            }
}   }
