package View;

import Figures.Figure;
import View.MyActionListener.WindowFigureAL;
import View.MyActionListener.BackToMainActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class FigureSettings<T extends Figure> extends JFrame {

    private JButton buttonBack;
    private ActionListener alBack;
    private JLabel labelid;
    private JTextField textid;

    private JLabel label1;
    private JButton button1;
    private ActionListener al1;
    private JButton button2;
    private ActionListener al2;
    private JButton button3;
    private ActionListener al3;
    private JButton button4;
    private ActionListener al4;
    private JButton button5;
    private ActionListener al5;

    private JLabel labelx;
    private JLabel labely;
    private JTextField coordx;
    private JTextField coordy;

    public FigureSettings(int width, int height, Color bgcolor, MainWindow mw, Window ow, FigureCreator<T> creator,
                          String uniqueTextButton) {

        setSize(width, height);
        setLocation(1000, 10);
        setBackground(bgcolor);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);

        buttonBack = new JButton("Back");
        alBack = new BackToMainActionListener(this, mw, ow);
        buttonBack.addActionListener(alBack);
        buttonBack.setBounds(50, 30, 400, 50);
        add(buttonBack);

        labelid = new JLabel("Choose id to methods:");
        labelid.setBounds(50, 700, 200, 25);
        add(labelid);

        textid = new JTextField();
        textid.setBounds(200, 700, 50, 25);
        textid.setBackground(Color.CYAN);
        add(textid);

        //button1
        label1 = new JLabel("id: ");
        label1.setBounds(300, 130, 50, 50);
        add(label1);

        button1 = new JButton("Create Figure");
        if (!mw.mainIsArray) al1 = new WindowFigureAL<>(ow, 1, label1, creator, mw, mw.myLinkedList);
        else al1 = new WindowFigureAL<>(ow, 1, label1, creator, mw, mw.myArray);
        button1.addActionListener(al1);
        button1.setBounds(50, 130, 200, 50);
        add(button1);


        //button2
        labelx = new JLabel("x:");
        labelx.setBounds(270, 230, 25, 25);
        add(labelx);

        coordx = new JTextField();
        coordx.setBounds(270, 255, 50, 25);
        coordx.setBackground(Color.CYAN);
        add(coordx);

        labely = new JLabel("y:");
        labely.setBounds(350, 230, 25, 25);
        add(labely);

        coordy = new JTextField();
        coordy.setBounds(350, 255, 50, 25);
        coordy.setBackground(Color.CYAN);
        add(coordy);

        button2 = new JButton("Move to");
        if (!mw.mainIsArray) al2 = new WindowFigureAL<>(ow, 2, coordx, coordy, textid, mw, mw.myLinkedList);
        else al2 = new WindowFigureAL<>(ow, 2, coordx, coordy, textid, mw, mw.myArray);
        button2.addActionListener(al2);
        button2.setBounds(50, 230, 200, 50);
        add(button2);


        //button3
        button3 = new JButton("Show");
        if (!mw.mainIsArray) al3 = new WindowFigureAL<>(ow, 3, textid, mw, mw.myLinkedList);
        else al3 = new WindowFigureAL<>(ow, 3, textid, mw, mw.myArray);
        button3.addActionListener(al3);
        button3.setBounds(50, 330, 400, 50);
        add(button3);


        //button4
        button4 = new JButton("Delete");
        if (!mw.mainIsArray) al4 = new WindowFigureAL<>(ow, 4, textid, mw, mw.myLinkedList);
        else al4 = new WindowFigureAL<>(ow, 4, textid, mw, mw.myArray);
        button4.addActionListener(al4);
        button4.setBounds(50, 430, 400, 50);
        add(button4);


        //button5
        button5 = new JButton(uniqueTextButton);
        if (!mw.mainIsArray) al5 = new WindowFigureAL<>(ow, 5, textid, mw, mw.myLinkedList);
        else al5 = new WindowFigureAL<>(ow, 5, textid, mw, mw.myArray);
        button5.addActionListener(al5);
        button5.setBounds(50, 530, 400, 50);
        add(button5);
    }

    public void free() {
        buttonBack = null;
        alBack = null;
        labelid = null;
        textid = null;

        label1 = null;
        button1 = null;
        al1 = null;
        button2 = null;
        al2 = null;
        button3 = null;
        al3 = null;
        button4 = null;
        al4 = null;
        button5 = null;
        al5 = null;

        labelx = null;
        labely = null;
        coordx = null;
        coordy = null;
    }
}
