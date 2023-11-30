package Figures;
import View.Window;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Trapeze extends Rectangle {
    protected int width2;

    public Trapeze(int x, int y, int width, int height, int width2, Window ow) {
        super(x, y, width, height, ow);
        this.width2 = width2;
        System.out.println("The trapeze was created");
    }

    public Trapeze(Window ow) {
        super(ow);
        this.width2 = ThreadLocalRandom.current().nextInt(50, 150);
        System.out.println("The trapeze was created");
    }

    public void changeWH() {
        width += ThreadLocalRandom.current().nextInt(-20, 20);
        height += ThreadLocalRandom.current().nextInt(-20, 20);
    }

    @Override
    public void callingTheUniqueFunction() {changeWH();}

    @Override
    public void paintComponent() {
        Graphics g = this.ow.getGraphics();
        g.setColor(this.color);
        System.out.println(this.color);
        int[] x = {this.point.getX() - this.width2 / 2, this.point.getX() - width / 2,
                this.point.getX() + this.width / 2, this.point.getX() + this.width2 / 2};
        int[] y = {this.point.getY() - this.height / 2, this.point.getY() + this.height / 2,
                this.point.getY() + this.height / 2, this.point.getY() - this.height / 2};
        g.fillPolygon(x, y, 4);
        g = null;
    }
}
