package Figures;

import View.Window;

import java.awt.*;

public abstract class Figure {
    protected Point point;
    protected Window ow;
    protected Color color = Color.white;
    public boolean isShowed = false;

    protected Figure(int x, int y, Window ow) {
        this.point = new Point(x, y);
        this.ow = ow;
    }

    public void Show() {
        if (isShowed && color == Color.BLUE) {
            setColor(Color.white);
            this.paintComponent();
        }
        else {
            setColor(Color.BLUE);
            this.paintComponent();
            isShowed = true;
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color newColor) {
        color = newColor;
    }

    public void MoveTo(int x, int y) {
        changeCoords(x, y);
        this.paintComponent();
    }

    public void changeCoords(int x, int y) {
        point.setX(point.getX() + x);
        point.setY(point.getY() + y);
    }

    public abstract void callingTheUniqueFunction();

    public void paintComponent() {};
}