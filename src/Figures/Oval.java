package Figures;
import View.Window;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Oval extends Circle {
    protected int radius2;

    public Oval(int x1, int y1, int radius1, int radius2, Window ow) {
        super(x1, y1, radius1, ow);
        this.radius2 = radius2;

        if (point.getX() + this.radius > 490) {
            point.setX(ThreadLocalRandom.current().nextInt(50, 350));
            this.radius = ThreadLocalRandom.current().nextInt(50, 150);
        }
        if (point.getY() + this.radius2 > 490) {
            point.setY(ThreadLocalRandom.current().nextInt(50, 350));
            this.radius2 = ThreadLocalRandom.current().nextInt(50, 150);
        }
        System.out.println("The oval was created");
    }

    public Oval(Window ow) {
        super(ThreadLocalRandom.current().nextInt(50, 350),
                ThreadLocalRandom.current().nextInt(50, 350),
                ThreadLocalRandom.current().nextInt(50, 150), ow);
        this.radius2 = ThreadLocalRandom.current().nextInt(50, 150);
        System.out.println("The oval was created");
    }

    public void changeWidthHeight() {
        int t = radius;
        radius = radius2;
        radius2 = t;
    }

    @Override
    public void callingTheUniqueFunction() {changeWidthHeight();}

    @Override
    public void paintComponent() {
        Graphics g = this.ow.getGraphics();
        g.setColor(this.color);
        System.out.println(this.color);
        g.fillOval(point.getX(), point.getY(), radius, radius2);
        g = null;
    }
}