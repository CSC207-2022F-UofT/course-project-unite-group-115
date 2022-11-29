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

        JTextArea textArea= new JTextArea(30, 45);
        textArea.setEditable(true);
        textArea.setFont(Font.getFont(Font.SANS_SERIF));
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JButton refresh = new JButton("Refresh");
        JButton react = new JButton("React");
        JButton cancel = new JButton("Cancel");

        JPanel buttons = new JPanel();
        buttons.add(refresh);
        buttons.add(react);
        buttons.add(cancel);

        refresh.addActionListener(this);
        react.addActionListener( this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(scroller);
        this.add(buttons);

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        System.out.println("Click " + evt.getActionCommand());
        if (evt.getActionCommand().equals("React")){
            JFrame reaction = new ReactionScreen(reactionController);
            reaction.pack();
            reaction.setVisible(true);
        } else if (evt.getActionCommand().equals("Cancel")) {
            JComponent component = (JComponent) evt.getSource();
            Window win = SwingUtilities.getWindowAncestor(component);
            win.dispose();
        }
    }
}
