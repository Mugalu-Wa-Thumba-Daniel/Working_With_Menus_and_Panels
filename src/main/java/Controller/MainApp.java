package Controller;

import Views.HomePanel;
import javax.swing.SwingUtilities;

/**
 * MainApp is the entry point of the application.
 * It initializes the HomePanel first, then the MainFrame.
 */
public class MainApp {
    public static void main(String[] args) {
        // Run the application on the Event Dispatch Thread (EDT) to ensure thread safety
        SwingUtilities.invokeLater(() -> {
            try {
                HomePanel homePanel = new HomePanel();
                homePanel.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
