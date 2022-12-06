package screens;

import database_classes.MessageDataAccess;
import database_classes.MessageRepoInt;
import reaction_use_case.interface_adapters.ReactionController;
import message_view.application_business_rule.ViewMessageInputBoundary;
import message_view.application_business_rule.ViewMessageInteractor;
import message_view.interface_adaptor.ViewMessageController;
import message_view.interface_adaptor.ViewMessagePresenter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * UI class contains the text area to display all current messages
 * and buttons to refresh the messages displayed, open the reaction panel,
 * and return to the previous page.
 * @author  Hansel Jia
 */
public class MessageDisplayScreen extends JPanel implements ActionListener{

    public MessageRepoInt messageRepoInt;
    public ReactionController reactionController;

    public String messages;

    public String groupID;

    public String username;

    public MessageDisplayScreen(MessageRepoInt messageRepoInt, ReactionController controller,
                                String messages, String groupID, String username){
        // Instantiate controller
        this.messageRepoInt = messageRepoInt;
        this.reactionController = controller;
        this.messages = messages;
        this.groupID = groupID;
        this.username = username;

        // Create new text area to display messages.
        JTextArea textArea= new JTextArea(30, 70);
        textArea.append(this.messages);
        textArea.setEditable(false);
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
        if (evt.getActionCommand().equals("Refresh")){
            MessageRepoInt message;
            try {
                message = new MessageDataAccess("./src/main/java/databases/messages.csv");
            } catch (IOException e) {
                throw new RuntimeException("Could not create file.");
            }
            ViewMessagePresenter presenter = new ViewMessagePresenter();
            ViewMessageInputBoundary interactor = new ViewMessageInteractor(message, presenter);
            ViewMessageController viewMessageController = new ViewMessageController(interactor);
            try {
                viewMessageController.create(groupID, username);
                String messages = " " + String.format(ViewMessageController.create(groupID, username).getPresented());
                messages = messages.replace("[", "").replace("]", "");
                messages = messages.replace(",", " ");

                JComponent component = (JComponent) evt.getSource();
                Window win = SwingUtilities.getWindowAncestor(component);
                win.dispose();
                JFrame newView = new MessagesView(messageRepoInt, messages, this.groupID, this.username);
                newView.pack();
                newView.setVisible(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        } else if (evt.getActionCommand().equals("React")){
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
