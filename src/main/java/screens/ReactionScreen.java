package screens;

import interface_adapters.ReactionController;
import reaction_use_case.ReactionResponseModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * UI class of the reaction window which includes the inputs
 * of messageID and the reaction to be added/removed.
 * The messageID is manually inputted and the reaction is
 * selected from a dropdown box. There are also 2 buttons
 * specifying whether the user wants to perform the action
 * of add or remove.
 * @author  Hansel Jia
 */
public class ReactionScreen extends JFrame implements ActionListener {

    JTextField ID = new JTextField(5);

    // Reactions available to choose from
    String[] reactions = {"heart", "smile", "cry"};

    ReactionComboBox newContentPane;
    ReactionController reactionController;

    public ReactionScreen(ReactionController controller){
        // Set frame properties
        this.reactionController = controller;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("React");

        JPanel all = new JPanel();
        all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));

        // Add title
        JLabel title = new JLabel("Reaction Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Create and set up the combo box.
        newContentPane = new ReactionComboBox(reactions);

        // Set up messageID input field
        LabelTextPanel messageID = new LabelTextPanel(
                new JLabel("Message ID:"), ID);

        JButton addReaction = new JButton("Add Reaction");
        JButton removeReaction = new JButton("Remove Reaction");

        // Group buttons in one JPanel
        JPanel buttons = new JPanel();
        buttons.add(addReaction);
        buttons.add(removeReaction);

        // Group inputs required to add/remove reaction into one panel
        JPanel inputs = new JPanel();
        inputs.add(messageID);
        inputs.add(newContentPane);
        // Add action listener
        addReaction.addActionListener(this);
        removeReaction.addActionListener(this);

        all.add(title);
        all.add(inputs);
        all.add(buttons);

        this.setContentPane(all);
        this.setVisible(true);

    }

    /**
     * Specify what actions to take upon press of each button.
     * "Add Reaction" calls the controller to add the reaction
     * "Remove Reaction" calls the controller to remove the reaction
     * @param evt The action event.
     */
    @Override
    public void actionPerformed(ActionEvent evt){
        System.out.println("Click " + evt.getActionCommand());
        int selectedReaction = Integer.parseInt(newContentPane.getSelected());
        if (evt.getActionCommand().equals("Add Reaction")){
            try {
                ReactionResponseModel i = reactionController.addReaction(reactions[selectedReaction], ID.getText());
                JOptionPane.showMessageDialog(this,
                        String.format("%s added", i.getReaction()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else if (evt.getActionCommand().equals("Remove Reaction")){
            try {
                ReactionResponseModel i = reactionController.removeReaction(reactions[selectedReaction], ID.getText());
                JOptionPane.showMessageDialog(this,
                        String.format("%s removed", i.getReaction()));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }
}
