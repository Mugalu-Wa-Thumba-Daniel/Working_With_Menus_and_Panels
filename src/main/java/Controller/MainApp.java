package Controller;

import javax.swing.SwingUtilities;
import Controller.MainFrame;

/**
 * MainApp is the entry point of the application.
 * It initializes the MainFrame.
 */
public class MainApp {
    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread (EDT) to ensure thread safety
        SwingUtilities.invokeLater(() -> {
            try {
                new MainFrame();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}