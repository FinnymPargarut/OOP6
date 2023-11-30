package Figures;

import View.Window;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Arc extends Figure {
    protected int width, height, startAngle, arcAngle;

    public Arc(int x1, int y1, int width, int height, int startAngle, int arcAngle, Window ow) {
        super(x1, y1, ow);
        this.width = width;
        this.height = height;
        this.startAngle = startAngle;
        this.arcAngle = arcAngle;

        if (point.getX() + this.width > 490) {
            point.setX(ThreadLocalRandom.current().nextInt(50, 350));
            this.width = ThreadLocalRandom.current().nextInt(50, 150);
        }
        if (point.getY() + this.height > 490) {
            point.setY(ThreadLocalRandom.current().nextInt(50, 350));
            this.height = ThreadLocalRandom.current().nextInt(50, 150);
        }
        System.out.println("The arc was created");
    }

    public Arc(Window ow) {
        super(ThreadLocalRandom.current().nextInt(50, 350),
                ThreadLocalRandom.current().nextInt(50, 350), ow);
        this.width = ThreadLocalRandom.current().nextInt(50, 150);
        this.height = ThreadLocalRandom.current().nextInt(50, 150);
        this.startAngle = ThreadLocalRandom.current().nextInt(30, 150);
        this.arcAngle = ThreadLocalRandom.current().nextInt(30, 150);
        System.out.println("The arc was created");
    }

    public void changeStartAngle() {
        int t = startAngle;
        if (startAngle > 10)
            startAngle = startAngle - 6;
        else {
            startAngle = t + 90;
        }
    }

    @Override
    public void callingTheUniqueFunction() {changeStartAngle();}

    @Override
    public void paintComponent() {
        Graphics g = this.ow.getGraphics();
        g.setColor(this.color);
        System.out.println(this.color);
        g.fillArc(point.getX(), point.getY(), width, height, startAngle, arcAngle);
        g = null;
    }
}
