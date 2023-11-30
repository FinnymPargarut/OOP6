package Figures;

import View.Window;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class FourBalls extends Figure {
    protected Circle circle1, circle2, circle3, circle4;
    public FourBalls(int x1, int y1, int radius, Window ow) {
        super(x1, y1, ow);
        this.circle1 = new Circle(x1, y1, radius, ow);
        this.circle2 = new Circle(x1 + radius, y1 + radius, radius, ow);
        this.circle3 = new Circle(x1, y1 + radius, radius, ow);
        this.circle4 = new Circle(x1 + radius, y1, radius, ow);
        System.out.println("The fourBalls was created");
    }

    public FourBalls(Window ow) {
        super(ThreadLocalRandom.current().nextInt(50, 350),
                ThreadLocalRandom.current().nextInt(50, 350), ow);
        int x1 = point.getX(); int y1 = point.getY();
        int radius = 50;
        this.circle1 = new Circle(x1, y1, radius, ow);
        this.circle2 = new Circle(x1 + radius, y1 + radius, radius, ow);
        this.circle3 = new Circle(x1, y1 + radius, radius, ow);
        this.circle4 = new Circle(x1 + radius, y1, radius, ow);
        this.ow = ow;
        System.out.println("The fourBalls was created");
    }

    @Override
    public void changeCoords(int x, int y) {
        circle1.MoveTo(x, y);
        circle2.MoveTo(x, y);
        circle3.MoveTo(x, y);
        circle4.MoveTo(x, y);
    }

    @Override
    public void setColor(Color newColor) {
        color = newColor;
        circle1.setColor(newColor);
        circle2.setColor(newColor);
        circle3.setColor(newColor);
        circle4.setColor(newColor);
    }

    public void changeRadiusCircles() {
        circle1.changeRadius();
        circle2.changeRadius();
        circle3.changeRadius();
        circle4.changeRadius();
    }

    @Override
    public void callingTheUniqueFunction() {changeRadiusCircles();}

    @Override
    public void paintComponent() {
        circle1.paintComponent();
        circle2.paintComponent();
        circle3.paintComponent();
        circle4.paintComponent();
    }
}
