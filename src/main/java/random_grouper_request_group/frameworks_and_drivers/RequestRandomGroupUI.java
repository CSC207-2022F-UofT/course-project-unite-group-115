package random_grouper_request_group.frameworks_and_drivers;

import random_grouper_request_group.interface_adapters.ReqRanGroupController;
import random_grouper_request_group.interface_adapters.ReqRanGroupPresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RequestRandomGroupUI extends JPanel implements ActionListener {
    ReqRanGroupController reqRanGroupController;

    JTextArea instructions = new JTextArea("Click below to be added to a random group that best matches with your" +
            " interests!");

    String loggedInUserName;

    public RequestRandomGroupUI(ReqRanGroupController controller, String loggedInUserName) {
        this.reqRanGroupController = controller;
        this.loggedInUserName = loggedInUserName;

        JLabel title = new JLabel("Request Random Group");

        instructions.setEditable(false);

        JButton addToGroup = new JButton("Request Random Group");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(addToGroup);
        buttons.add(cancel);

        addToGroup.addActionListener(this);
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
                JOptionPane.showMessageDialog(this, e.getMessage());
        }
    } else if (evt.getActionCommand().equals("Cancel")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
            }
}   }
