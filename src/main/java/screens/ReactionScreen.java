package screens;

import interface_adapters.ReactionController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReactionScreen extends JFrame implements ActionListener {

    JTextField ID = new JTextField(5);
    ReactionController reactionController;

    public ReactionScreen(ReactionController controller){
        this.reactionController = controller;
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel all = new JPanel();
        all.setLayout(new BoxLayout(all, BoxLayout.Y_AXIS));

        JLabel title = new JLabel("Reaction Screen");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        //Create and set up the content pane.
        JPanel newContentPane = new ReactionComboBox();

        TextPanel messageID = new TextPanel(
                new JLabel("Message ID:"), ID);

        JButton addReaction = new JButton("Add Reaction");
        JButton removeReaction = new JButton("Remove Reaction");

        // Group buttons in one JPanel
        JPanel buttons = new JPanel();
        buttons.add(addReaction);
        buttons.add(removeReaction);

        // Group messageID and reaction type in one JPanel
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
    }
}
