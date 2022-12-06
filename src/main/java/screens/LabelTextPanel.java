package screens;

import javax.swing.*;

// Frameworks/Drivers layer

public class LabelTextPanel extends JPanel {
    /**
     * Creates a panel with a text field and its label tag.
     * @param label the label tag for the text-field.
     * @param textField the area for user to pass an input.
     */
    public LabelTextPanel(JLabel label, JTextField textField) {
        this.add(label);
        this.add(textField);
    }
}
