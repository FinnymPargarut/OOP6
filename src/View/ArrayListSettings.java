package View;

import View.MyActionListener.ArrayListAL;
import View.MyActionListener.BackToMainActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ArrayListSettings extends JFrame {
    private JButton buttonBack;
    private ActionListener alBack;
    private JButton button1;
    private ActionListener al1;
    private JButton button2;
    private ActionListener al2;
    private JButton button3;
    private ActionListener al3;
    private JButton button4;
    private ActionListener al4;

    private JLabel choose;
    private JComboBox choice;
    private ActionListener alChoice;

    public ArrayListSettings(int width, int height, Color bgcolor, MainWindow mw, Window ow) {

        setSize(width, height);
        setLocation(1000, 10);
        setBackground(bgcolor);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);

        buttonBack = new JButton("Back");
        alBack = new BackToMainActionListener(this, mw);
        buttonBack.addActionListener(alBack);
        buttonBack.setBounds(50, 30, 400, 50);
        add(buttonBack);


        choose = new JLabel("Choose container:");
        choose.setBounds(270, 100, 200, 25);
        add(choose);

        choice = new JComboBox(new String[]{"Array", "List"});
        alChoice = new ArrayListAL(ow, 5, mw, choice);
        choice.addActionListener(alChoice);
        choice.setBounds(270, 120, 200, 25);
        add(choice);


        button1 = new JButton("Create");
        al1 = new ArrayListAL(ow, 1, mw, choice);
        button1.addActionListener(al1);
        button1.setBounds(50, 130, 200, 50);
        add(button1);

        button2 = new JButton("Move");
        al2 = new ArrayListAL(ow, 2, mw, choice);
        button2.addActionListener(al2);
        button2.setBounds(50, 230, 400, 50);
        add(button2);

        button3 = new JButton("Add Figure");
        al3 = new ArrayListAL(ow, 3, mw, choice);
        button3.addActionListener(al3);
        button3.setBounds(50, 330, 400, 50);
        add(button3);

        button4 = new JButton("Delete");
        al4 = new ArrayListAL(ow, 4, mw, choice);
        button4.addActionListener(al4);
        button4.setBounds(50, 430, 400, 50);
        add(button4);
    }
}
