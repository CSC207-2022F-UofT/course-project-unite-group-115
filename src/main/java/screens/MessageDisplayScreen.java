package screens;

import interface_adapters.ReactionController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * UI class contains the text area to display all current messages
 * and buttons to refresh the messages displayed, open the reaction panel,
 * and return to the previous page.
 * @author  Hansel Jia
 */
public class MessageDisplayScreen extends JPanel implements ActionListener{
    ReactionController reactionController;


    public MessageDisplayScreen(ReactionController controller){
        // Instantiate controller
        this.reactionController = controller;

        // Create new text area to display messages.
        JTextArea textArea= new JTextArea(30, 45);
        textArea.setEditable(true);
        textArea.setFont(Font.getFont(Font.SANS_SERIF));
        // Set the text area as scrollable.
        JScrollPane scroller = new JScrollPane(textArea);
        scroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        // Add buttons
        JButton refresh = new JButton("Refresh");
        JButton react = new JButton("React");
        JButton cancel = new JButton("Cancel");
        JPanel buttons = new JPanel();
        buttons.add(refresh);
        buttons.add(react);
        buttons.add(cancel);
        // Add action listener to buttons
        refresh.addActionListener(this);
        react.addActionListener( this);
        cancel.addActionListener(this);

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(scroller);
        this.add(buttons);

    }

    /**
     * Specify what actions to take upon press of each button.
     * "Refresh" gets all current messages from the database to display,
     * "React" opens up the reaction panel
     * "Cancel" closes the window
     * @param evt The action event.
     */
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
