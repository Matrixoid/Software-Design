package ru.chmykhalov.sd.bridge.drawing;

public interface DrawingAPI {
    void initEngine(int screenSize, int graphSize);

    int getScreenSize();

    int getGraphSize();

    void drawPoint(double x, double y);

    void drawLine(double x1, double y1, double x2, double y2);

    void drawLoop(double vx, double vy, double dirAngle);

    void show();
}
