package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Window extends JDialog {
    public Window(int width, int height, Color bgColor) {
        super();
        setVisible(true);
        setSize(width, height);
        setLocation(0, 150);
        getContentPane().setBackground(bgColor);
        setResizable(false);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        System.out.println("Painting");
    }
}
