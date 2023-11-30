package Figures;
import View.Window;

import java.awt.*;
import java.util.concurrent.ThreadLocalRandom;

public class Rhombus extends Rectangle {
    public Rhombus(int x, int y, int width, int height, Window ow) {
        super(x, y, width, height, ow);
        System.out.println("The rhombus was created");
    }

    public Rhombus(Window ow) {
        super(ow);
        System.out.println("The rhombus was created");
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
        int[] x = {this.point.getX() - this.width / 2, this.point.getX(),
                this.point.getX() + this.width / 2, this.point.getX()};
        int[] y = {this.point.getY(), this.point.getY() - this.height / 2,
                this.point.getY(), this.point.getY() + this.height / 2};
        g.fillPolygon(x, y, 4);
        g = null;
    }
}
