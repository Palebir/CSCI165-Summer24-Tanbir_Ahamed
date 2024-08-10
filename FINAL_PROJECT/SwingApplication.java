import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;

/**
 * This class sets up the basic Swing application. It creates a JFrame
 * and adds a RaymarcherPanel to it. The main method initializes the frame,
 * adds the panel, and makes it visible.
 */
public class SwingApplication {
    public static void main(String[] args) {
        // Create a new JFrame (a top-level container)
        JFrame frame = new JFrame("Swing Application");

        // Set the default close operation. This is what happens when the user clicks the "close" button.
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create an instance of the RaymarcherPanel class
        RaymarcherPanel panel = new RaymarcherPanel();

        // Add the panel to the frame's content pane
        frame.getContentPane().add(panel, BorderLayout.CENTER);

        // Pack the frame so that it fits the preferred sizes of its components
        frame.pack();

        // Center the frame on the screen
        frame.setLocationRelativeTo(null);

        // Make the frame visible
        frame.setVisible(true);
    }
}
