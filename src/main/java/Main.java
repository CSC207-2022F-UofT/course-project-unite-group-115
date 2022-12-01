

import entities.ReactionFactory;
import interface_adapters.ReactionController;
import interface_adapters.ReactionPresenter;
import databases.*;
import reaction_use_case.ReactionInputBoundary;
import reaction_use_case.ReactionInteractor;
import screens.MessageDisplayScreen;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setTitle("Messages");
//        CardLayout cardLayout = new CardLayout();
//        JPanel screens = new JPanel(cardLayout);
//        frame.add(screens);

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
        frame.add(messageScreenButtons, BorderLayout.CENTER);
        frame.pack();
//        cardLayout.show(screens, "messages");
        frame.setVisible(true);

    }
}
