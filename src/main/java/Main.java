

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
        JFrame application = new JFrame();
        CardLayout cardLayout = new CardLayout();
        JPanel screens = new JPanel(cardLayout);
        application.add(screens);

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

        MessageDisplayScreen messageScreen = new MessageDisplayScreen(controller);
        screens.add(messageScreen);
        cardLayout.show(screens, "messages");
        application.pack();
        application.setVisible(true);
        System.out.println("Hello World");
    }
}
