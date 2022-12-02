package screens;

import databases.MessageFile;
import databases.MessageRepoInt;
import entities.ReactionFactory;
import interface_adapters.ReactionController;
import interface_adapters.ReactionPresenter;
import reaction_use_case.ReactionInputBoundary;
import reaction_use_case.ReactionInteractor;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MessagesView extends JFrame {

    public MessagesView(){
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setTitle("Messages");
        MessageRepoInt message;
        try {
            message = new MessageFile("./messages.csv");
        } catch (IOException e){
            throw new RuntimeException("Could not create file");
        }
        ReactionPresenter presenter = new ReactionPresenter();
        ReactionFactory reactionFactory = new ReactionFactory();
        ReactionInputBoundary interactor = new ReactionInteractor(message, presenter, reactionFactory);
        ReactionController controller = new ReactionController(interactor);

//         Test reactions by adding a message manually
//        List<String> emptyList = new ArrayList<String>();
//        LocalDateTime now = LocalDateTime.now();
//        MessageDsRequestModel request = new MessageDsRequestModel("bye","Michael","475",
//                "2", emptyList, now);
//        message.save(request);



        MessageDisplayScreen messageScreenButtons = new MessageDisplayScreen(controller);
        this.add(messageScreenButtons, BorderLayout.CENTER);
        this.pack();
//        cardLayout.show(screens, "messages");
        this.setVisible(true);
    }

}
