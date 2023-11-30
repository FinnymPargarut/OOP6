package View;

@FunctionalInterface
public interface FigureCreator<T> {
    T createFigure(Window ow);
}