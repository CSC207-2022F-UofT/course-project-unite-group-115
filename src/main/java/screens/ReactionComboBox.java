package screens;

import java.awt.*;
import javax.swing.*;

public class ReactionComboBox extends JPanel {
    ImageIcon[] images;
    String[] reactions = {"heart", "smile", "cry"};
    public ReactionComboBox(){
        super (new BorderLayout());

        // Load the reaction images and create an array of indexes
        images = new ImageIcon[reactions.length];
        Integer[] intArray = new Integer[reactions.length];
        for (int i = 0; i < reactions.length; i++) {
            intArray[i] = i;
            images[i] = createImageIcon("src/main/java/screens/" + reactions[i] + ".png");
            if (images[i] != null) {
                images[i].setDescription(reactions[i]);
            }
        }

        //Create the combo box.
        JComboBox<Integer> reactions = new JComboBox<>(intArray);
        ComboBoxRenderer renderer= new ComboBoxRenderer();
        renderer.setPreferredSize(new Dimension(100, 70));
        reactions.setRenderer(renderer);
        reactions.setMaximumRowCount(3);

        //Lay out the demo.
        add(reactions, BorderLayout.PAGE_START);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }
    protected static ImageIcon createImageIcon(String path) {
//        java.net.URL imgURL = ReactionComboBox.class.getResource(path);
//        System.out.println(imgURL);
        if (path != null) {
            return new ImageIcon(path);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    class ComboBoxRenderer extends JLabel
            implements ListCellRenderer {
        private Font uhOhFont;

        public ComboBoxRenderer() {
            setOpaque(true);
            setHorizontalAlignment(CENTER);
            setVerticalAlignment(CENTER);
        }

        /*
         * This method finds the image and text corresponding
         * to the selected value and returns the label, set up
         * to display the text and image.
         */
        @Override
        public Component getListCellRendererComponent(
                JList list,
                Object value,
                int index,
                boolean isSelected,
                boolean cellHasFocus) {
            //Get the selected index. (The index param isn't
            //always valid, so just use the value.)
            int selectedIndex = (Integer) value;

            if (isSelected) {
                setBackground(list.getSelectionBackground());
                setForeground(list.getSelectionForeground());
            } else {
                setBackground(list.getBackground());
                setForeground(list.getForeground());
            }

            //Set the icon and text.  If icon was null, say so.
            ImageIcon icon = images[selectedIndex];
            String react = reactions[selectedIndex];
            setIcon(icon);
            if (icon != null) {
                setText(react);
                setFont(list.getFont());
            } else {
                setUhOhText(react + " (no image available)",
                        list.getFont());
            }

            return this;
        }

        //Set the font and text when no image was found.
        protected void setUhOhText(String uhOhText, Font normalFont) {
            if (uhOhFont == null) { //lazily create this font
                uhOhFont = normalFont.deriveFont(Font.ITALIC);
            }
            setFont(uhOhFont);
            setText(uhOhText);
        }
    }


}
