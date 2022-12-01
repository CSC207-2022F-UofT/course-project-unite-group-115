package screens;

import interface_adapters.ReactionController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReactionScreen extends JFrame implements ActionListener {

    JTextField ID = new JTextField(5);

    String[] reactions = {"heart", "smile", "cry"};

    ReactionComboBox newContentPane;
    ReactionController reactionController;

    public ReactionScreen(ReactionController controller){
        this.reactionController = controller;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("React");

        JPanel all = new JPanel();
        all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Reaction Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Create and set up the content pane.
        newContentPane = new ReactionComboBox(reactions);

        TextPanel messageID = new TextPanel(
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

        addReaction.addActionListener(this);
        removeReaction.addActionListener(this);

        all.add(title);
        all.add(inputs);
        all.add(buttons);

        this.setContentPane(all);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent evt){
        System.out.println("Click " + evt.getActionCommand());
        int selectedReaction = Integer.parseInt(newContentPane.getSelected());
        if (evt.getActionCommand().equals("Add Reaction")){
            try {
                reactionController.addReaction(reactions[selectedReaction], ID.getText());
                JOptionPane.showMessageDialog(this,
                        String.format("%s added", reactions[selectedReaction]));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else if (evt.getActionCommand().equals("Remove Reaction")){
            System.out.println(reactions[selectedReaction] + ID.getText());
            try {
                reactionController.removeReaction(reactions[selectedReaction], ID.getText());
                JOptionPane.showMessageDialog(this,
                        String.format("%s removed", reactions[selectedReaction]));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }
}
