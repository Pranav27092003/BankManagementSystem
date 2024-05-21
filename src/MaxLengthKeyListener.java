import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class MaxLengthKeyListener implements KeyListener {
    private int maxLength;

    public MaxLengthKeyListener(int maxLength) {
        this.maxLength = maxLength;
    }

    @Override
    public void keyTyped(KeyEvent e) {
        JTextField textField = (JTextField) e.getSource();
        String text = textField.getText();
        if (text.length() >= maxLength) {
            e.consume(); // Consume the key event to prevent further input
            JOptionPane.showMessageDialog(null, "Maximum length reached!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Not needed for this example
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not needed for this example
    }
}
