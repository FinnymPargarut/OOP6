package Figures.Containers;

import Figures.Figure;

public abstract class MyContainer {

    public abstract Figure getFigure(int id);
    public abstract void removeFigure(int id);
    public abstract void addFigure(Figure figure);
    public abstract int getSize();

    protected int x = 10; protected int y = 0;
    public void setXInMoveIterationMethod(int x) {this.x = x;}
    public void setYInMoveIterationMethod(int y) {this.y = y;}
    public abstract void iteratorMethod(int methodNumber);

    public abstract void removeAllFigures();
    public abstract void free();
}
