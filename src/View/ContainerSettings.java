package View;

import View.MyActionListener.BackToMainActionListener;
import View.MyActionListener.ContainerAL;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ContainerSettings extends JFrame {
    private JButton buttonBack;
    private ActionListener alBack;
    private JButton buttonFill;
    private ActionListener alFill;
    private JButton buttonShow;
    private ActionListener alShow;
    private JButton buttonMove;
    private ActionListener alMove;
    private JButton buttonErase;
    private ActionListener alErase;
    private JButton buttonDelete;
    private ActionListener alDelete;


    private JLabel labelx;
    private JLabel labely;
    private JTextField coordx;
    private JTextField coordy;

    private JLabel podierarchyLabel;
    private JComboBox choosePodierarchy;
    private ActionListener alChoosePodierarchy;
    private JButton podierarchyMoveButton;
    private ActionListener podierarchyMoveAL;
    private JButton podierarcheUniqueMethodButton;
    private ActionListener podierarchyUniqueMethodAL;
    public ContainerSettings(int width, int height, Color bgcolor, MainWindow mw, Window ow) {

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

        //button1
        buttonFill = new JButton("Fill");
        if (!mw.mainIsArray) alFill = new ContainerAL<>(ow, 1, mw, mw.myLinkedList);
        else alFill = new ContainerAL<>(ow, 1, mw, mw.myArray);
        buttonFill.addActionListener(alFill);
        buttonFill.addKeyListener(new ContainerAL<>(ow, 0, mw, mw.myArray));
        buttonFill.setBounds(50, 130, 400, 50);
        add(buttonFill);

        //button2
        buttonShow = new JButton("Show");
        if (!mw.mainIsArray) alShow = new ContainerAL<>(ow, 2, mw, mw.myLinkedList);
        else alShow = new ContainerAL<>(ow, 2, mw, mw.myArray);
        buttonShow.addActionListener(alShow);
        buttonShow.addKeyListener(new ContainerAL<>(ow, 0, mw, mw.myArray));
        buttonShow.setBounds(50, 230, 400, 50);
        add(buttonShow);


        //button3
        labelx = new JLabel("x:");
        labelx.setBounds(270, 330, 25, 25);
        add(labelx);

        coordx = new JTextField();
        coordx.setBounds(270, 355, 50, 25);
        coordx.setBackground(Color.CYAN);
        add(coordx);

        labely = new JLabel("y:");
        labely.setBounds(350, 330, 25, 25);
        add(labely);

        coordy = new JTextField();
        coordy.setBounds(350, 355, 50, 25);
        coordy.setBackground(Color.CYAN);
        add(coordy);

        buttonMove = new JButton("Move");
        if (!mw.mainIsArray) alMove = new ContainerAL<>(ow, 3, coordx, coordy, mw, mw.myLinkedList);
        else alMove = new ContainerAL<>(ow, 3, coordx, coordy, mw, mw.myArray);
        buttonMove.addActionListener(alMove);
        buttonMove.addKeyListener(new ContainerAL<>(ow, 0, mw, mw.myArray));
        buttonMove.setBounds(50, 330, 200, 50);
        add(buttonMove);


        //button4
        buttonErase = new JButton("Erase");
        if (!mw.mainIsArray) alErase = new ContainerAL<>(ow, 4, mw, mw.myLinkedList);
        else alErase = new ContainerAL<>(ow, 4, mw, mw.myArray);
        buttonErase.addActionListener(alErase);
        buttonErase.addKeyListener(new ContainerAL<>(ow, 0, mw, mw.myArray));
        buttonErase.setBounds(50, 430, 400, 50);
        add(buttonErase);

        //button5
        buttonDelete = new JButton("Delete");
        if (!mw.mainIsArray) alDelete = new ContainerAL<>(ow, 5, mw, mw.myLinkedList);
        else alDelete = new ContainerAL<>(ow, 5, mw, mw.myArray);
        buttonDelete.addActionListener(alDelete);
        buttonDelete.addKeyListener(new ContainerAL<>(ow, 0, mw, mw.myArray));
        buttonDelete.setBounds(50, 530, 400, 50);
        add(buttonDelete);


        //Podierarchy methods
        podierarchyLabel = new JLabel("Podierarchy methods");
        podierarchyLabel.setBounds(200, 605, 400, 50);
        add(podierarchyLabel);

        choosePodierarchy = new JComboBox(new String[]{"Circle", "Rectangle"});
        if (!mw.mainIsArray) alChoosePodierarchy = new ContainerAL<>(ow, 6, choosePodierarchy, mw, mw.myLinkedList);
        else alChoosePodierarchy = new ContainerAL<>(ow, 6, choosePodierarchy, mw, mw.myArray);
        choosePodierarchy.addActionListener(alChoosePodierarchy);
        choosePodierarchy.addKeyListener(new ContainerAL<>(ow, 0, mw, mw.myArray));
        choosePodierarchy.setBounds(50, 650, 200, 25);
        add(choosePodierarchy);

        podierarchyMoveButton = new JButton("PodierarchyMove");
        if (!mw.mainIsArray) podierarchyMoveAL = new ContainerAL<>(ow, 7, choosePodierarchy, mw, mw.myLinkedList);
        else podierarchyMoveAL = new ContainerAL<>(ow, 7, choosePodierarchy, mw, mw.myArray);
        podierarchyMoveButton.addActionListener(podierarchyMoveAL);
        podierarchyMoveButton.addKeyListener(new ContainerAL<>(ow, 0, mw, mw.myArray));
        podierarchyMoveButton.setBounds(270, 650, 200, 25);
        add(podierarchyMoveButton);

        podierarcheUniqueMethodButton = new JButton("PodierarchyUniqueMethod");
        if (!mw.mainIsArray) podierarchyUniqueMethodAL = new ContainerAL<>(ow, 8, choosePodierarchy, mw, mw.myLinkedList);
        else podierarchyUniqueMethodAL = new ContainerAL<>(ow, 8, choosePodierarchy, mw, mw.myArray);
        podierarcheUniqueMethodButton.addActionListener(podierarchyUniqueMethodAL);
        podierarcheUniqueMethodButton.addKeyListener(new ContainerAL<>(ow, 0, mw, mw.myArray));
        podierarcheUniqueMethodButton.setBounds(270, 685, 200, 25);
        add(podierarcheUniqueMethodButton);
    }
}
