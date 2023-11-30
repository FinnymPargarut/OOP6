package Figures;
import View.Window;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Rectangle extends Figure {
    protected int width, height;

    public Rectangle(int x, int y, int width, int height, Window ow) {
        super(x, y, ow);
        this.width = width;
        this.height = height;
        this.ow = ow;
        System.out.println("The rectangle was created");
    }

    public Rectangle(Window ow) {
        super(ThreadLocalRandom.current().nextInt(50, 350),
                ThreadLocalRandom.current().nextInt(50, 350), ow);
        this.width = ThreadLocalRandom.current().nextInt(50, 150);
        this.height = ThreadLocalRandom.current().nextInt(50, 150);
        System.out.println("The rectangle was created");
    }

    public void changeWidthHeight() {
        int t = width;
        width = height;
        height = t;
    }

    @Override
    public void callingTheUniqueFunction() {changeWidthHeight();}

    @Override
    public void paintComponent() {
        Graphics g = this.ow.getGraphics();
        g.setColor(this.color);
        System.out.println(this.color);
        g.drawRect(point.getX(), point.getY(), width, height);
        g = null;
    }
}