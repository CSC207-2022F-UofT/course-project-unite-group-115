

import entities.ReactionFactory;
import interface_adapters.ReactionController;
import interface_adapters.ReactionPresenter;
import reaction_use_case.ReactionDsGateway;
import Databases.*;
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

        ReactionDsGateway reaction;
        try {
            reaction = new ReactionFile("./reactions.csv");
        } catch (IOException e){
            throw new RuntimeException("Could not create file");
        }
        ReactionPresenter presenter = new ReactionPresenter();
        ReactionFactory reactionFactory = new ReactionFactory();
        ReactionInputBoundary interactor = new ReactionInteractor(reaction, presenter, reactionFactory);
        ReactionController controller = new ReactionController(interactor);

        MessageDisplayScreen messageScreenButtons = new MessageDisplayScreen(controller);
        frame.add(messageScreenButtons, BorderLayout.CENTER);
        frame.pack();
//        cardLayout.show(screens, "messages");
        frame.setVisible(true);

    }
}
