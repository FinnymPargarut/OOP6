package Figures;
import View.Window;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.*;

public class Line extends Figure {
    protected Point point2;

    public Line (int x1, int y1, int x2, int y2, Window ow) {
        super(x1, y1, ow);
        this.point2 = new Point(x2, y2);
        this.ow = ow;

        if (point.getX() > 490 | point.getX() < 10) {
            point.setX(ThreadLocalRandom.current().nextInt(120, 300));
        }
        if (point.getY() > 490 | point.getY() < 10) {
            point.setY(ThreadLocalRandom.current().nextInt(50, 300));
        }
        if (point2.getX() > 490 | point2.getX() < 10) {
            point2.setX(ThreadLocalRandom.current().nextInt(120, 300));
        }
        if (point2.getY() > 490 | point2.getY() < 10) {
            point2.setY(ThreadLocalRandom.current().nextInt(50, 300));
        }
        System.out.println("The line was created");
    }

    public Line(Window ow) {
        super(ThreadLocalRandom.current().nextInt(120, 300),
                ThreadLocalRandom.current().nextInt(50, 300), ow);
        this.point2 = new Point(ThreadLocalRandom.current().nextInt(point.getX() + 10, 350),
                ThreadLocalRandom.current().nextInt(point.getY()+10, 350));
        this.ow = ow;
        System.out.println("The line was created");
    }

    @Override
    public void changeCoords(int x, int y) {
        point.setX(point.getX() + x);
        point.setY(point.getY() + y);
        point2.setX(point2.getX() + x);
        point2.setY(point2.getY() + y);
    }

    public void reverse() {
        int t = point.getY();
        point.setY(point2.getY());
        point2.setY(t);
    }

    @Override
    public void callingTheUniqueFunction() {reverse();}

    @Override
    public void paintComponent() {
        Graphics g = this.ow.getGraphics();
        g.setColor(this.color);
        System.out.println(this.color);
        g.drawLine(point.getX(), point.getY(), point2.getX(), point2.getY());
        g = null;
    }
}