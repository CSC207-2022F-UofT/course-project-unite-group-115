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

        // Set up use case files
//        MessageRepoInt message;
//        try {
//            message = new MessageDataAccess("./messages.csv");
//        } catch (IOException e){
//            throw new RuntimeException("Could not create file");
//        }
        ReactionPresenter presenter = new ReactionPresenter();
        ReactionInputBoundary interactor = new ReactionInteractor(messageRepoInt, presenter);
        ReactionController controller = new ReactionController(interactor);

//         Test reactions by adding a message manually
//        List<String> emptyList = new ArrayList<>();
//        LocalDateTime now = LocalDateTime.now();
//        MessageDsRequestModel request = new MessageDsRequestModel("hey","Michael","475",
//                "3", emptyList, now);
//        message.save(request);



        MessageDisplayScreen messageScreenButtons = new MessageDisplayScreen(messageRepoInt, controller,
                messages, groupID, username);
        this.add(messageScreenButtons, BorderLayout.CENTER);
        this.pack();
//        cardLayout.show(screens, "messages");
        this.setVisible(true);
    }

}
