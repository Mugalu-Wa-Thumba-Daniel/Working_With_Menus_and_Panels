package Views;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HomePanelTest {
    private HomePanel homePanel;

    @BeforeEach
    void setUp() {
        homePanel = new HomePanel();
    }

    @Test
    void shouldSetVisibilityToTrue() {
        homePanel.setVisible(true);
        assertTrue(homePanel.isVisible());
    }

    @Test
    void shouldSetVisibilityToFalse() {
        homePanel.setVisible(false);
        assertFalse(homePanel.isVisible());
    }
}
