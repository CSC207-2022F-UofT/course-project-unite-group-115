package screens;

import interface_adapters.ReactionController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageDisplayScreenButtons extends JPanel implements ActionListener{
    ReactionController reactionController;

    JTextField addReactionID = new JTextField(7);

    JTextField removeReactionID = new JTextField(7);

    public MessageDisplayScreenButtons(ReactionController controller){
        this.reactionController = controller;

        TextPanel addReaction = new TextPanel(
                new JLabel("Choose ID to add reaction"), addReactionID);
        TextPanel removeReaction = new TextPanel(
                new JLabel("Choose ID to remove reaction"), removeReactionID);
        JButton refresh = new JButton("Refresh");
        JButton react = new JButton("React");

        JPanel buttons = new JPanel();
        buttons.add(refresh);
        buttons.add(react);

        refresh.addActionListener(this);
        react.addActionListener( this);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(addReaction);
        this.add(removeReaction);
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());

    }
}
