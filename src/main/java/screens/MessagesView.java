package screens;

import database_classes.MessageRepoInt;
import reaction_use_case.interface_adapters.ReactionController;
import reaction_use_case.interface_adapters.ReactionPresenter;
import reaction_use_case.application_business_rules.ReactionInputBoundary;
import reaction_use_case.application_business_rules.ReactionInteractor;
import javax.swing.*;
import java.awt.*;

/**
 * UI class which contains the frame that the messages will be displayed on.
 * Pass inputs onto the MessageDisplayScreen so the buttons in the panel can
 * send information to the controller
 * @author  Hansel Jia
 */
public class MessagesView extends JFrame {

    public MessageRepoInt messageRepoInt;
    public String messages;

    public String groupID;

    public String username;
    public MessagesView(MessageRepoInt messageRepoInt, String messages, String groupID, String username){
        // Set up identity of the frame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Messages");
        this.messageRepoInt = messageRepoInt;
        this.messages = messages;
        this.groupID = groupID;
        this.username = username;

        ReactionPresenter presenter = new ReactionPresenter();
        ReactionInputBoundary interactor = new ReactionInteractor(messageRepoInt, presenter);
        ReactionController controller = new ReactionController(interactor);

        MessageDisplayScreen messageScreenButtons = new MessageDisplayScreen(messageRepoInt, controller,
                messages, groupID, username);
        this.add(messageScreenButtons, BorderLayout.CENTER);
        this.pack();
        this.setVisible(true);
    }

}
