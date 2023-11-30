package View.MyActionListener;

import Figures.Containers.*;
import Figures.*;
import Figures.Rectangle;
import View.MainWindow;
import View.Window;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ThreadLocalRandom;

public class ContainerAL<C extends MyContainer> extends KeyAdapter implements ActionListener {
    private Window ow;
    private int numbutton;
    private JTextField tfx, tfy;
    private JComboBox comboBoxPodierarhy;
    private boolean isCirclePodierarchy = true;
    private MainWindow mw;
    private C container;

    public ContainerAL(Window ow, int numbutton, MainWindow mw, C container) {
        this.ow = ow;
        this.numbutton = numbutton;
        this.mw = mw;
        this.container = container;
    }

    public ContainerAL(Window ow, int numbutton, JTextField tfx, JTextField tfy, MainWindow mw, C container) {
        this.ow = ow;
        this.numbutton = numbutton;
        this.tfx = tfx;
        this.tfy = tfy;
        this.mw = mw;
        this.container = container;
    }

    public ContainerAL(Window ow, int numbutton, JComboBox choosePodierarhy, MainWindow mw, C container) {
        this.ow = ow;
        this.numbutton = numbutton;
        this.comboBoxPodierarhy = choosePodierarhy;
        this.mw = mw;
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (numbutton) {
            case 1 -> fill();
            case 2 -> show();
            case 3 -> move();
            case 4 -> erase();
            case 5 -> delete();
            case 6 -> choosePodierarchy();
            case 7 -> podierarchyMove();
            case 8 -> podierarchyUniqueMethod();
        }
    }

//    private void removeFigures() {
//        for (int id = 0; id < container.getSize(); id++) {
//            if (container.getFigure(id) != null){
//                if (container.getFigure(id).isShowed && container.getFigure(id).getColor() == Color.BLUE)
//                    container.getFigure(id).Show();
//                System.out.printf("figure %d was deleted%n", id);
//            }
//        }
//        container.removeAllFigures();
//    }

    private void fill() {
        delete();
        for (int i = 0; i < 21; i++) {
            int numFigure = ThreadLocalRandom.current().nextInt(1, 10);
            switch (numFigure) {
                case 1 -> container.addFigure(new Oval(ow));
                case 2 -> container.addFigure(new Line(ow));
                case 3 -> container.addFigure(new Circle(ow));
                case 4 -> container.addFigure(new Arc(ow));
                case 5 -> container.addFigure(new FourBalls(ow));
                case 6 -> container.addFigure(new Head(ow));
                case 7 -> container.addFigure(new Rectangle(ow));
                case 8 -> container.addFigure(new Rhombus(ow));
                case 9 -> container.addFigure(new Trapeze(ow));
            }
        }
    }

    private void show() {
        for (int id = 0; id < container.getSize(); id++) {
            if (container.getFigure(id) != null) {
                container.getFigure(id).Show();
            }
        }
        updateWindow();
    }

    private void move() {
        if (!tfx.getText().isEmpty() && !tfy.getText().isEmpty()) {
            int x = Integer.parseInt(tfx.getText());
            int y = Integer.parseInt(tfy.getText());
            moveTo(x, y);
        }
    }

    private void erase() {
        for (int id = 0; id < container.getSize(); id++) {
            if (container.getFigure(id) != null)
                if (container.getFigure(id).isShowed && container.getFigure(id).getColor() == Color.BLUE) {
                    container.getFigure(id).Show();
    //                container.getFigure(id).setColor(Color.BLUE);
            }
        }
    }

    private void delete() {
        erase();
        container.removeAllFigures();
        System.out.println("Container was cleared");
    }

    private void choosePodierarchy() {
        isCirclePodierarchy = comboBoxPodierarhy.getSelectedItem() == "Circle";
        System.out.println(isCirclePodierarchy);
    }

    private void podierarchyMove() {
        choosePodierarchy();
        int x = ThreadLocalRandom.current().nextInt(-20, 20);
        int y = ThreadLocalRandom.current().nextInt(-20, 20);
        for (int id = 0; id < container.getSize(); id++) {
            if (isCirclePodierarchy && container.getFigure(id) instanceof Circle ||
                    !isCirclePodierarchy && container.getFigure(id) instanceof Rectangle) {

                if (container.getFigure(id).isShowed && container.getFigure(id).getColor() == Color.BLUE) {
                    container.getFigure(id).Show();
                    container.getFigure(id).setColor(Color.BLUE);
                }
                container.getFigure(id).MoveTo(x, y);
            }
        }
        updateWindow();
    }

    private void podierarchyUniqueMethod() {
        choosePodierarchy();
        for (int id = 0; id < container.getSize(); id++) {
            if (isCirclePodierarchy && container.getFigure(id) instanceof Circle ||
                    !isCirclePodierarchy && container.getFigure(id) instanceof Rectangle) {

                if (container.getFigure(id).isShowed && container.getFigure(id).getColor() == Color.BLUE) {
                    container.getFigure(id).Show();
                    container.getFigure(id).setColor(Color.BLUE);
                }
                if (container.getFigure(id) instanceof Circle)
                    ((Circle) container.getFigure(id)).changeRadius();
                else if (container.getFigure(id) instanceof Rectangle) {
                    ((Rectangle) container.getFigure(id)).changeWidthHeight();
                }
            }
        }
        updateWindow();
    }

    private void updateWindow() {
        for (int id = 0; id < container.getSize(); id++) {
            if (container.getFigure(id) != null && container.getFigure(id).isShowed &&
                    container.getFigure(id).getColor() == Color.BLUE) {
                container.getFigure(id).paintComponent();
                System.out.println(id);
            }
        }
    }

    private void moveTo(int x, int y) {
        for (int j = 0; j < container.getSize(); j++) {
            if (container.getFigure(j) != null) {
                if (container.getFigure(j).isShowed && container.getFigure(j).getColor() == Color.BLUE) {
                    container.getFigure(j).Show();
                    container.getFigure(j).setColor(Color.BLUE);
                }
                container.getFigure(j).MoveTo(x, y);
            }
        }
        updateWindow();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case 37 -> moveTo(-10, 0);
            case 38 -> moveTo(0, -10);
            case 39 -> moveTo(10, 0);
            case 40 -> moveTo(0, 10);
        }
    }
}