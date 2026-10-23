
import javax.swing.*;
import java.awt.*;

class MyPanel extends JPanel {

    private JLabel label;
    private int textIndex = 0;
    private int colorIndex = 0;

    private final String[] messages = {
            "Welcome to Java Swing First Individual Assignment by Alpha Hamidu Jalloh!",
            "Hello! Welcome to my application!",
            "This is my Java Swing assignment!",
            "Thank you for using my application!",
            "Keep learning and improving!"
    };

    private final Color[] colors = {
            Color.LIGHT_GRAY,
            Color.CYAN,
            Color.YELLOW,
            Color.PINK,
            Color.ORANGE,
            Color.GREEN,
            Color.RED
    };

    // Constructor
    public MyPanel() {

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBackground(colors[colorIndex]);
        setBorder(BorderFactory.createEmptyBorder(35, 20, 20, 20));

        // Load the image and resize it to a suitable size
        ImageIcon originalIcon = new ImageIcon("src/icon.png");

        Image resizedImage = originalIcon.getImage()
                .getScaledInstance(45, 45, Image.SCALE_SMOOTH);

        ImageIcon icon = new ImageIcon(resizedImage);

        // Welcome label with a small icon
        label = new JLabel(messages[textIndex], icon, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 16));
        label.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(label);
        add(Box.createVerticalStrut(25));

        // Create the buttons
        JButton textButton = new JButton("Change Text");
        JButton colorButton = new JButton("Change Background");

        textButton.setFont(new Font("Arial", Font.BOLD, 14));
        colorButton.setFont(new Font("Arial", Font.BOLD, 14));

        // Keep the buttons together
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 12, 5));
        buttonPanel.setOpaque(false);

        buttonPanel.add(textButton);
        buttonPanel.add(colorButton);

        buttonPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(buttonPanel);

        // Change text every time the button is clicked
        textButton.addActionListener(e -> {
            textIndex = (textIndex + 1) % messages.length;
            label.setText(messages[textIndex]);
        });

        // Change background colour every time the button is clicked
        colorButton.addActionListener(e -> {
            colorIndex = (colorIndex + 1) % colors.length;
            setBackground(colors[colorIndex]);
            repaint();
        });
    }
}

public class SwingAssignment extends JFrame {

    // Constructor
    public SwingAssignment() {
        setTitle("Java Swing Assignment");
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        add(new MyPanel());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingAssignment app = new SwingAssignment();
            app.setVisible(true);
        });
    }
}
