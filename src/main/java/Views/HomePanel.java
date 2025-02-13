package Views;

import Controller.MainFrame;
import javax.swing.*;
import java.awt.*;

/**
 * HomePanel is the welcome screen of the application.
 * It displays a welcome message and an enter button to navigate to the menu.
 */
public class HomePanel extends JPanel {
    private MainFrame mainFrame;

    public HomePanel(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
        setLayout(new BorderLayout());
        configureWelcomeLabel();
        configureEnterButton();
    }

    /**
     * Configures the welcome label and adds it to the panel.
     */
    private void configureWelcomeLabel() {
        JLabel welcomeLabel = new JLabel("Welcome to the App", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        add(welcomeLabel, BorderLayout.NORTH);
    }

    /**
     * Configures the enter button and adds it to the panel.
     */
    private void configureEnterButton() {
        JButton enterButton = new JButton("Enter");
        enterButton.setPreferredSize(new Dimension(200, 50));
        enterButton.addActionListener(e -> {
            CardLayout cl = (CardLayout) getParent().getLayout();
            cl.show(getParent(), "menuCard");
        });

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        buttonPanel.add(enterButton);
        add(buttonPanel, BorderLayout.CENTER);
    }
}
