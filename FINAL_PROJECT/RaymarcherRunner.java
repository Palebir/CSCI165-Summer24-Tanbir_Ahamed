/**
 * RaymarcherRunner is the driver class where the JPanel
 * is initialized and instantiated.
 * 
 * This class will be run to being the program
 */
import javax.swing.JFrame;

public class RaymarcherRunner {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Raymarcher");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        RaymarcherPanel panel = new RaymarcherPanel();
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center the frame
        frame.setVisible(true);
    }
}
