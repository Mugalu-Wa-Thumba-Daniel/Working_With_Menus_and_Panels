package Views;

import Controller.MainFrame;
import javax.swing.*;
import java.awt.*;

/**
 * HomePanel is the welcome screen of the application.
 * It displays a welcome message and an enter button to navigate to the menu.
 */
public class HomePanel {
    private JFrame frame;

    public HomePanel() {
        frame = new JFrame("Welcome To Hospital H+");
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());
        configureComponents();
    }

    private void configureComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel iconLabel = new JLabel(new ImageIcon("src/main/resources/images/image_1.png")); // Remplace le chemin par le chemin de ton icône
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        frame.add(iconLabel, gbc);

        JLabel welcomeLabel = new JLabel("Welcome To Hospital H+", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        frame.add(welcomeLabel, gbc);

        JButton enterButton = new JButton("Enter");
        enterButton.setPreferredSize(new Dimension(300, 40));
        enterButton.setFont(new Font("Arial", Font.BOLD, 17));
        enterButton.addActionListener(e -> {
            new MainFrame();
            frame.dispose();
        });
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(enterButton, gbc);
    }

    public boolean setVisible(boolean visible) {
        frame.setVisible(visible);
        return visible;
    }

    public boolean isVisible() {
        return false;
    }
}
