package View.MyActionListener;

import Figures.*;
import Figures.Containers.MyArray;
import Figures.Containers.MyLinkedList;
import Figures.Rectangle;
import View.MainWindow;
import View.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class ArrayListAL implements ActionListener {

    private Window ow;
    private MainWindow mw;
    private int numbutton;
    private JComboBox choice;
    private boolean isArray = true;

    public ArrayListAL(Window ow, int numbutton, MainWindow mw, JComboBox choice) {
        this.ow = ow;
        this.mw = mw;
        this.numbutton = numbutton;
        this.choice = choice;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (numbutton) {
            case 1 -> create();
            case 2 -> move();
            case 3 -> addRandomFigure();
            case 4 -> delete();
            case 5 -> chooseContainer();
        }
    }

    private void chooseContainer() {
        isArray = choice.getSelectedItem() == "Array";
        mw.mainIsArray = choice.getSelectedItem() == "Array";
        System.out.println(mw.mainIsArray);
    }

    private void create() {
        chooseContainer();
        if (isArray) {
            mw.myArray = new MyArray(30);
        } else {
            mw.myLinkedList = new MyLinkedList();
        }
    }

    private void move() {
        chooseContainer();
        if (isArray) {
            mw.myArray.iteratorMethod(1);
        } else {
            mw.myLinkedList.iteratorMethod(1);
        }
        updateWindow();
    }

    private void addRandomFigure() {
        chooseContainer();
        int numFigure = ThreadLocalRandom.current().nextInt(1, 10);
        if (isArray) {
            switch (numFigure) {
                case 1 -> mw.myArray.addFigure(new Oval(ow));
                case 2 -> mw.myArray.addFigure(new Line(ow));
                case 3 -> mw.myArray.addFigure(new Circle(ow));
                case 4 -> mw.myArray.addFigure(new Arc(ow));
                case 5 -> mw.myArray.addFigure(new FourBalls(ow));
                case 6 -> mw.myArray.addFigure(new Head(ow));
                case 7 -> mw.myArray.addFigure(new Rectangle(ow));
                case 8 -> mw.myArray.addFigure(new Rhombus(ow));
                case 9 -> mw.myArray.addFigure(new Trapeze(ow));
            }
            mw.myArray.getFigure(mw.myArray.getSize()-1).Show();
        } else {
            switch (numFigure) {
                case 1 -> mw.myLinkedList.addFigure(new Oval(ow));
                case 2 -> mw.myLinkedList.addFigure(new Line(ow));
                case 3 -> mw.myLinkedList.addFigure(new Circle(ow));
                case 4 -> mw.myLinkedList.addFigure(new Arc(ow));
                case 5 -> mw.myLinkedList.addFigure(new FourBalls(ow));
                case 6 -> mw.myLinkedList.addFigure(new Head(ow));
                case 7 -> mw.myLinkedList.addFigure(new Rectangle(ow));
                case 8 -> mw.myLinkedList.addFigure(new Rhombus(ow));
                case 9 -> mw.myLinkedList.addFigure(new Trapeze(ow));
            }
//            System.out.println(mw.myLinkedList.getSize()-1);
            mw.myLinkedList.getFigure(mw.myLinkedList.getSize()-1).Show();
        }
    }

    private void updateWindow() {
        if (mw.myArray != null) {
            for (int id = 0; id < mw.myArray.getSize(); id++) {
                if (mw.myArray.getFigure(id) != null && mw.myArray.getFigure(id).isShowed &&
                        mw.myArray.getFigure(id).getColor() == Color.BLUE) {
                    mw.myArray.getFigure(id).paintComponent();
                    System.out.println(id);
                }
            }
        }
        if (mw.myLinkedList != null) {
            for (int id = 0; id < mw.myLinkedList.getSize(); id++) {
                if (mw.myLinkedList.getFigure(id) != null && mw.myLinkedList.getFigure(id).isShowed &&
                        mw.myLinkedList.getFigure(id).getColor() == Color.BLUE) {
                    mw.myLinkedList.getFigure(id).paintComponent();
                    System.out.println(id);
                }
            }
        }
    }

    private void delete() {
        chooseContainer();
        if (isArray) {
            mw.myArray.iteratorMethod(5);
            mw.myArray.free();
            mw.myArray = null;
            System.out.println("Array was deleted");
        } else {
            mw.myLinkedList.iteratorMethod(5);
            mw.myLinkedList.free();
            mw.myLinkedList = null;
            System.out.println("Linked list was deleted");
        }
        updateWindow();
    }
}
