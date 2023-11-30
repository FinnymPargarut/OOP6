package View;

import Figures.Containers.MyArray;
import Figures.Containers.MyLinkedList;
import View.MyActionListener.MainWindowActionListener;

import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class MainWindow extends JFrame {
    public Window ow1;
    public MyArray myArray;
    public MyLinkedList myLinkedList;
    public boolean mainIsArray;
    public MainWindow(int width, int weight, Color bgcolor, Window ow) {
        this.ow1 = ow;
//        ow1.setVisible(false);

        setSize(width, weight);
        setLocation(500, 30);
        setBackground(bgcolor);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);

        JButton buttonOval = createButton(this, ow1, 1, "Oval");
        buttonOval.setBounds(50, 20, 400, 45);
        add(buttonOval);

        JButton buttonLine = createButton(this, ow1, 2, "Line");
        buttonLine.setBounds(50, 85, 400, 45);
        add(buttonLine);

        JButton buttonCircle = createButton(this, ow1, 3, "Circle");
        buttonCircle.setBounds(50, 150, 400, 45);
        add(buttonCircle);

        JButton buttonArc = createButton(this, ow1, 4, "Arc");
        buttonArc.setBounds(50, 215, 400, 45);
        add(buttonArc);

        JButton buttonFourBalls = createButton(this, ow1, 5, "FourBalls");
        buttonFourBalls.setBounds(50, 280, 400, 45);
        add(buttonFourBalls);

        JButton buttonHead = createButton(this, ow1, 6, "Head");
        buttonHead.setBounds(50, 345, 400, 45);
        add(buttonHead);

        JButton buttonRectangle = createButton(this, ow1, 7, "Rectangle");
        buttonRectangle.setBounds(50, 410, 400, 45);
        add(buttonRectangle);

        JButton buttonRhombus = createButton(this, ow1, 8, "Rhombus");
        buttonRhombus.setBounds(50, 475, 400, 45);
        add(buttonRhombus);

        JButton buttonTrapeze = createButton(this, ow1, 9, "Trapeze");
        buttonTrapeze.setBounds(50, 540, 400, 45);
        add(buttonTrapeze);

        JButton buttonContainer = createButton(this, ow1, 10, "Container");
        buttonContainer.setBounds(50, 605, 400, 45);
        add(buttonContainer);

        JButton buttonList = createButton(this, ow1, 11, "Array and list");
        buttonList.setBounds(50, 670, 400, 45);
        add(buttonList);
    }

    @org.jetbrains.annotations.NotNull
    private JButton createButton(MainWindow mw, Window ow, int numFig, String text) {
        JButton button = new JButton(text);
        ActionListener al = new MainWindowActionListener(mw, ow, numFig);
        button.addActionListener(al);
        return button;
    }
}
