

import entities.ReactionFactory;
import interface_adapters.ReactionController;
import interface_adapters.ReactionPresenter;
import reaction_use_case.ReactionDsGateway;
import Databases.*;
import reaction_use_case.ReactionInputBoundary;
import reaction_use_case.ReactionInteractor;
import screens.MessageDisplayScreenButtons;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;


public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame();
        frame.setSize(500, 650);
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

        MessageDisplayScreenButtons messageScreenButtons = new MessageDisplayScreenButtons(controller);
        frame.add(messageScreenButtons, BorderLayout.SOUTH);
//        cardLayout.show(screens, "messages");
        frame.setVisible(true);

    }
}
