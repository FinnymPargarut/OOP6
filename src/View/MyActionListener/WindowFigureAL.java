package View.MyActionListener;

import Figures.Containers.MyContainer;
import Figures.Figure;
import View.FigureCreator;
import View.MainWindow;
import View.Window;
import org.jetbrains.annotations.NotNull;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.*;

public class WindowFigureAL<T extends Figure, C extends MyContainer> implements ActionListener {
    private FigureCreator<T> figureCreator;
    private Window ow;
    private MainWindow mw;
    private int numbutton;
    private JLabel label;
    private JTextField tfx; private JTextField tfy; private JTextField textid;
    private C container;

    private int id;
    public WindowFigureAL(Window ow, int numbutton, JLabel label, FigureCreator<T> creator, MainWindow mw, C container) {
        this.ow = ow;
        this.numbutton = numbutton;
        this.label = label;
        this.figureCreator = creator;
        this.mw = mw;
        this.container = container;
    }

    public WindowFigureAL(Window ow, int numbutton, JTextField tfx, JTextField tfy,
                        JTextField textid, MainWindow mw, C container) {
        this.ow = ow;
        this.numbutton = numbutton;
        this.tfx = tfx;
        this.tfy = tfy;
        this.textid = textid;
        this.mw = mw;
        this.container = container;
    }

    public WindowFigureAL(Window ow, int numbutton, JTextField textid, MainWindow mw, C container) {
        this.ow = ow;
        this.numbutton = numbutton;
        this.textid = textid;
        this.mw = mw;
        this.container = container;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (numbutton) {
            case 1 -> create();
            case 2 -> moveTo();
            case 3 -> show();
            case 4 -> remove();
            case 5 -> uniqueFunction();
        }
    }

    private void create() {
        id = container.getSize();
        T figure = figureCreator.createFigure(ow);
        container.addFigure(figure);
        System.out.println(container.getSize());
        label.setText("id: " + Integer.toString(id));
    }

    private void moveTo() {
        if (!tfx.getText().isEmpty() && !tfy.getText().isEmpty() && !textid.getText().isEmpty()) {
            int x = Integer.parseInt(tfx.getText());
            int y = Integer.parseInt(tfy.getText());
            int[] idArr = getIdArr(textid);
            for (int j : idArr) {
                if (j < container.getSize() && container.getFigure(j) != null) {
                    if (container.getFigure(j).isShowed && container.getFigure(j).getColor() == Color.BLUE) {
                        container.getFigure(j).Show();
                        container.getFigure(j).setColor(Color.BLUE);
                    }
                    container.getFigure(j).MoveTo(x, y);
                }
            }
            updateWindow();
        }
    }

    private void show() {
        int[] idArr = getIdArr(textid);
        for (int j : idArr) {
            if (j < container.getSize()) {
                container.getFigure(j).Show();
            }
        }
        updateWindow();
//        System.out.println(container.getSize());
//        System.out.println(Arrays.toString(idArr));
    }

    private void remove() {
        int[] idArr = getIdArr(textid);
        for (int j : idArr) {
            if (container.getFigure(j) != null){
                if (container.getFigure(j).isShowed && container.getFigure(j).getColor() == Color.BLUE)
                    container.getFigure(j).Show();
                container.removeFigure(j);
                System.out.printf("figure %d was deleted%n", j);
            }
        }
        updateWindow();
    }

    private void uniqueFunction() {
        int[] idArr = getIdArr(textid);
        for (int j : idArr) {
            if (j < container.getSize() && container.getFigure(j) != null) {
                if (container.getFigure(j).isShowed && container.getFigure(j).getColor() == Color.BLUE) {
                    container.getFigure(j).Show();
                    container.getFigure(j).setColor(Color.BLUE);
                }
                container.getFigure(j).callingTheUniqueFunction();
            }
        }
        updateWindow();
    }

    private int @NotNull [] getIdArr(JTextField textId) {
        String strid = textid.getText();
        String[] strArr = strid.split(" ");
        int[] idArr = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++)
            idArr[i] = Integer.parseInt(strArr[i]);
        return idArr;
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
}
