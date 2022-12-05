package screens;

import databases.MessageFile;
import databases.MessageRepoInt;
import interface_adapters.ReactionController;
import interface_adapters.ReactionPresenter;
import reaction_use_case.ReactionInputBoundary;
import reaction_use_case.ReactionInteractor;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

/**
 * UI class which contains the frame that the messages will be displayed on.
 * Pass inputs onto the MessageDisplayScreen so the buttons in the panel can
 * send information to the controller
 * @author  Hansel Jia
 */
public class MessagesView extends JFrame {

    public MessagesView(){
        // Set up identity of the frame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Messages");

        // Set up use case files
        MessageRepoInt message;
        try {
            message = new MessageFile("./messages.csv");
        } catch (IOException e){
            throw new RuntimeException("Could not create file");
        }
        ReactionPresenter presenter = new ReactionPresenter();
        ReactionInputBoundary interactor = new ReactionInteractor(message, presenter);
        ReactionController controller = new ReactionController(interactor);

//         Test reactions by adding a message manually
//        List<String> emptyList = new ArrayList<>();
//        LocalDateTime now = LocalDateTime.now();
//        MessageDsRequestModel request = new MessageDsRequestModel("hey","Michael","475",
//                "3", emptyList, now);
//        message.save(request);



        MessageDisplayScreen messageScreenButtons = new MessageDisplayScreen(controller);
        this.add(messageScreenButtons, BorderLayout.CENTER);
        this.pack();
//        cardLayout.show(screens, "messages");
        this.setVisible(true);
    }

}
