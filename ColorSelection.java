import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ColorSelection extends JFrame {
    
    private JLabel colorLabel;
    private JSlider redSlider, greenSlider, blueSlider, opacitySlider;

    //constructor
    public ColorSelection() {
        // set up JFrame
        setTitle("Color Selection");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        colorLabel = new JLabel("Selected Color");
        colorLabel.setHorizontalAlignment(JLabel.CENTER);

        redSlider = createSlider("Red", 0, 255, 0);
        greenSlider = createSlider("Green", 0, 255, 0);
        blueSlider = createSlider("Blue", 0, 255, 0);
        opacitySlider = createSlider("Opacity", 0, 100, 100);

        // add components to frame
        add(colorLabel);
        add(redSlider);
        add(greenSlider);
        add(blueSlider);
        add(opacitySlider);

        // attach listeners to each slider
        redSlider.addChangeListener(new ColorChangeListener());
        greenSlider.addChangeListener(new ColorChangeListener());
        blueSlider.addChangeListener(new ColorChangeListener());
        opacitySlider.addChangeListener(new ColorChangeListener());

        // set initial color
        updateColor();
        setVisible(true);
    }

    // helper method to create slider
    private JSlider createSlider(String label, int min, int max, int initialValue) {
        JSlider slider = new JSlider(JSlider.HORIZONTAL, min, max, initialValue);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(10);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBorder(BorderFactory.createTitledBorder(Label));
        return slider;
    }

    // helper method to update color
    private void updateColor() {
        int red = redSlider.getValue();
        int green = greenSlider.getValue();
        int blue = blueSlider.getValue();
        int opacity = opacitySlider.getValue();

        float opacityPercentage = opacity / 100f;

        colorLabel.setForeground(new Color(red, green, blue, (int) (255 * opacityPercentage)));
    }

    //inner class for slider change events
    private class ColorChangeListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent e) {
            updateColor();
        }
    }

    public static void main(Stringp[] args) {
        SwingUtilities.invokeLater(() -> new ColorSelecction());
    }
}
