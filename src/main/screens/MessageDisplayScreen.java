package screens;

import interface_adapters.ReactionController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MessageDisplayScreen extends JPanel{
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

        refresh.addActionListener((ActionListener) this);
        react.addActionListener((ActionListener) this);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(title);
        this.add(buttons);
    }
}
