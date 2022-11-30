package general_group.screens;

import general_group.interface_adapters.GeneralGroupCreateController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class GeneralGroupCreationScreen extends JPanel implements ActionListener, ItemListener {

    GeneralGroupCreateController controller;

    public GeneralGroupCreationScreen(GeneralGroupCreateController controller) {
        this.controller = controller;
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }
}
