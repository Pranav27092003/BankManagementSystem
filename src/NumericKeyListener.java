import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class NumericKeyListener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        char c = e.getKeyChar();
        if (!Character.isDigit(c) && !Character.isISOControl(c) && !Character.isSpaceChar(c)) {
            e.consume();
            JOptionPane.showMessageDialog(null, "Only numeric values are allowed!", "Input Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
