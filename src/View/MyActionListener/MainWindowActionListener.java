package View.MyActionListener;

import Figures.*;
import Figures.Rectangle;
import View.*;
import View.Window;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindowActionListener implements ActionListener {
    private MainWindow mw;
    private View.Window ow;
    private int numberFigure;

    public MainWindowActionListener(MainWindow visibleFalse, Window visibleTrue, int numberFigure) {
        this.mw = visibleFalse;
        this.ow = visibleTrue;
        this.numberFigure = numberFigure;
    }

    public void actionPerformed(ActionEvent e) {
        mw.setVisible(false);
        ow.setVisible(true);

        ChoiceFigure(numberFigure);
    }

    private void ChoiceFigure(int numberFigure) {
        if (numberFigure == 1) {
            FigureCreator<Oval> creator = (Oval::new);
            FigureSettings<Oval> ovalFigureSettings = new FigureSettings<>(500, 800, Color.white, mw, ow,
                    creator, "Change width and height");

        } else if (numberFigure == 2) {
            FigureCreator<Line> creator = (Line::new);
            FigureSettings<Line> lineFigureSettings = new FigureSettings<>(500, 800, Color.white, mw, ow,
                    creator, "Reverse");

        } else if (numberFigure == 3) {
            FigureCreator<Circle> creator = (Circle::new);
            FigureSettings<Circle> circleFigureSettings = new FigureSettings<>(500, 800, Color.white, mw,
                    ow, creator, "Change radius");

        } else if (numberFigure == 4) {
            FigureCreator<Arc> creator = (Arc::new);
            FigureSettings<Arc> arcFigureSettings = new FigureSettings<>(500, 800, Color.white, mw, ow,
                    creator, "Change start angle");

        } else if (numberFigure == 5) {
            FigureCreator<FourBalls> creator = (FourBalls::new);
            FigureSettings<FourBalls> fourBallsFigureSettings = new FigureSettings<>(500, 800, Color.white,
                    mw, ow, creator, "Change radius");

        } else if (numberFigure == 6) {
            FigureCreator<Head> creator = (Head::new);
            FigureSettings<Head> headFigureSettings = new FigureSettings<>(500, 800, Color.white, mw, ow,
                    creator, "changeMohawk");

        } else if (numberFigure == 7) {
            FigureCreator<Rectangle> creator = (Rectangle::new);
            FigureSettings<Rectangle> rectangleFigureSettings = new FigureSettings<>(500, 800, Color.white,
                    mw, ow, creator, "Change width and height");

        } else if (numberFigure == 8) {
            FigureCreator<Rhombus> creator = (Rhombus::new);
            FigureSettings<Rhombus> rhombusFigureSettings = new FigureSettings<>(500, 800, Color.white, mw,
                    ow, creator, "Random change width and height");

        } else if (numberFigure == 9) {
            FigureCreator<Trapeze> creator = (Trapeze::new);
            FigureSettings<Trapeze> trapezeFigureSettings = new FigureSettings<>(500, 800, Color.white, mw,
                    ow, creator, "Random change width and height");
        } else if (numberFigure == 10) {
            ContainerSettings containerSettings = new ContainerSettings(500, 800, Color.white, mw, ow);
        } else if (numberFigure == 11) {
            ArrayListSettings arrayListSettings = new ArrayListSettings(500, 550, Color.white, mw, ow);
        }
    }
}
