package Figures;

import View.Window;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Circle extends Figure {
    protected int radius;
    protected final int begin_radius;

    public Circle(int x1, int y1, int radius, Window ow) {
        super(x1, y1, ow);
        this.radius = radius;
        this.begin_radius = radius;

        if (point.getX() + this.radius > 490) {
            point.setX(ThreadLocalRandom.current().nextInt(50, 350));
            this.radius = ThreadLocalRandom.current().nextInt(50, 150);
        }
        if (point.getY() + this.radius > 490) {
            point.setY(ThreadLocalRandom.current().nextInt(50, 350));
            this.radius = ThreadLocalRandom.current().nextInt(50, 150);
        }
        System.out.println("The circle was created");
    }

    public Circle(Window ow) {
        super(ThreadLocalRandom.current().nextInt(50, 350),
                ThreadLocalRandom.current().nextInt(50, 350), ow);
        this.radius = ThreadLocalRandom.current().nextInt(50, 150);
        this.begin_radius = radius;
        this.ow = ow;
        System.out.println("The circle was created");
    }

    public void changeRadius() {
        if (radius - 10 > 0) {
            radius = radius - 6;
        } else {
            radius = begin_radius;
        }
    }

    @Override
    public void callingTheUniqueFunction() {changeRadius();}

    @Override
    public void paintComponent() {
        Graphics g = this.ow.getGraphics();
        g.setColor(this.color);
        System.out.println(this.color);
        g.fillOval(point.getX(), point.getY(), radius, radius);
        g = null;
    }
}
