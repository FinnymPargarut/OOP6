import View.MainWindow;
import View.Window;

import java.awt.Color;

public class Main {
    public static void main(String[] args) {
        Window ow = new Window(500, 500, Color.white);
        MainWindow mw = new MainWindow(500, 770, Color.white, ow);
    }
}