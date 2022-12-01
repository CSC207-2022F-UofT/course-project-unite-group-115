package screens;

import java.awt.*;
import java.util.Objects;
import javax.swing.*;

public class ReactionComboBox extends JPanel{
    ImageIcon[] images;
    String[] reactions;

    JComboBox<Integer> reactionBox;
    public ReactionComboBox(String[] react){
        super (new BorderLayout());
        this.reactions = react;
        // Load the reaction images and create an array of indexes
        images = new ImageIcon[reactions.length];
        Integer[] intArray = new Integer[reactions.length];
        for (int i = 0; i < reactions.length; i++) {
            intArray[i] = i;
            images[i] = createImageIcon("src/main/java/images/" + reactions[i] + ".png");
            if (images[i] != null) {
                images[i].setDescription(reactions[i]);
            }
        }

        //Create the combo box.
//        JComboBox<Integer>
        reactionBox = new JComboBox<>(intArray);
        ComboBoxRenderer renderer= new ComboBoxRenderer();
        renderer.setPreferredSize(new Dimension(100, 70));
        reactionBox.setRenderer(renderer);
        reactionBox.setMaximumRowCount(3);

        //Lay out the demo.
        add(reactionBox, BorderLayout.PAGE_START);
        setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
    }

    public String getSelected(){
        return Objects.requireNonNull(this.reactionBox.getSelectedItem()).toString();
    }

    protected static ImageIcon createImageIcon(String path) {
        if (path != null) {
            return new ImageIcon(path);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
    class ComboBoxRenderer extends JLabel implements ListCellRenderer<Object> {
        private Font exceptionFont;

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
                JList<?> list,
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
                setExceptionText(react + " (no image available)",
                        list.getFont());
            }

            return this;
        }

        //Set the font and text when no image was found.
        protected void setExceptionText(String exceptionText, Font normalFont) {
            if (exceptionFont == null) {
                exceptionFont = normalFont.deriveFont(Font.ITALIC);
            }
            setFont(exceptionFont);
            setText(exceptionText);
        }
    }


}
