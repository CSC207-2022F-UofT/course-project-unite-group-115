package screens;

import interface_adapters.ReactionController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageDisplayScreen extends JPanel implements ActionListener{
    ReactionController reactionController;

    public MessageDisplayScreen(ReactionController controller){
        this.reactionController = controller;
        JLabel title = new JLabel("Messages");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton refresh = new JButton("Refresh");
        JButton react = new JButton("React");

        JPanel buttons = new JPanel();
        buttons.add(refresh);
        buttons.add(react);

        refresh.addActionListener(this);
        react.addActionListener( this);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(title);
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
    }
}
