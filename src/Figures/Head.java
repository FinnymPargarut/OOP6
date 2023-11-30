package Figures;

import View.Window;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Head extends Figure {
    protected Circle circle;
    protected Arc arc;
    protected Line line;
    public Head(int x, int y, int radius, Window ow) {
        super(x, y, ow);
        this.circle = new Circle(x, y, radius, ow);
        this.arc = new Arc((int) (x+0.27*radius), (int) (y-0.2*radius), (int) (radius/2), (int) (radius/2), 30,
                120, ow);
        this.line = new Line((int) (x+0.3*radius), (int) (y+0.7*radius), (int) (x+0.7*radius), (int) (y+0.7*radius), ow);
        this.ow = ow;
        System.out.println("The head was created");
    }

    public Head(Window ow) {
        super(ThreadLocalRandom.current().nextInt(50, 350),
                ThreadLocalRandom.current().nextInt(50, 350), ow);
        int x = point.getX(); int y = point.getY();
        int radius = ThreadLocalRandom.current().nextInt(50, 150);
        this.circle = new Circle(x, y, radius, ow);
        this.arc = new Arc((int) (x+0.27*radius), (int) (y-0.2*radius), (int) (radius/2), (int) (radius/2), 30,
                120, ow);
        this.line = new Line((int) (x+0.3*radius), (int) (y+0.7*radius), (int) (x+0.7*radius), (int) (y+0.7*radius), ow);
        this.ow = ow;
        System.out.println("The head was created");
    }

    @Override
    public void changeCoords(int x, int y) {
        circle.MoveTo(x, y);
        arc.MoveTo(x, y);
        line.MoveTo(x, y);
    }

    @Override
    public void setColor(Color newColor) {
        color = newColor;
        circle.setColor(newColor);
        arc.setColor(newColor);
        line.setColor(newColor);
    }

    public void changeMohawk() {
        arc.changeStartAngle();
    }

    @Override
    public void callingTheUniqueFunction() {changeMohawk();}

    @Override
    public void paintComponent() {
        circle.paintComponent();
        arc.paintComponent();
        line.setColor(Color.white);
        line.paintComponent();
    }
}
