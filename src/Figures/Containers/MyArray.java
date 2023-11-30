package Figures.Containers;

import Figures.Figure;

import java.awt.*;

public class MyArray extends MyContainer {
    private Figure [] array;
    private int size;
    private int lastFillId = 0;
    public MyArray(int size) {
        this.size = size;
//        size = 30;
        array = new Figure[size];
    }
    public Figure getFigure(int id){
        if (id >= size | id < 0) return null;
        return array[id];
    }
    public void removeFigure(int id){
        if (id >=  size) return;
        Figure figure = this.getFigure(id);
        if (figure == null) return;
        array[id] = null;
    }
    public void addFigure(Figure figure){
        if (lastFillId >= size) {
            size += 10;
            Figure [] new_array = new Figure[size];
            for (int i = 0; i < this.getSize(); i++) {
                new_array[i] = array[i];
                array[i] = null;
            }
            array = new_array;
        }
        array[lastFillId] = figure;
        lastFillId += 1;
    }
    public int getSize(){
        return lastFillId;
    }

    public void iteratorMethod(int methodNumber) {
        for (int i = 0; i < getSize(); i++) {
            if (array[i] != null) {
                switch (methodNumber) {
                    case 1 -> {
                        if (array[i].isShowed && array[i].getColor() == Color.BLUE) {
                            array[i].Show();
                            array[i].setColor(Color.BLUE);
                        }
                        array[i].MoveTo(x, y);
                    }
                    case 2 -> array[i].Show();
                    case 3 -> {if (array[i].isShowed && array[i].getColor() == Color.white) array[i].Show();}
                    case 4 -> {if (array[i].isShowed && array[i].getColor() == Color.BLUE) array[i].Show();}
                    case 5 -> {
                        if (array[i].isShowed && array[i].getColor() == Color.BLUE) array[i].Show();
                        array[i] = null;
                    }
                }
            }
        }
    }

    public void removeAllFigures() {
        for (int i = 0; i < this.getSize(); i++)
            array[i] = null;
    }
    public void free(){
        removeAllFigures();
        array = null;
    }
}
