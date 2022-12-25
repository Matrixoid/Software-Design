package ru.chmykhalov.sd.bridge.drawing;

import ru.chmykhalov.sd.bridge.engine.AwtEngine;

import java.awt.*;

public class AwtDAPI implements DrawingAPI{

    private static final double pointRadius = 16;
    private static final Color pointColor = Color.DARK_GRAY;

    private static final int lineWidth = 3;
    private static final Color lineColor = Color.LIGHT_GRAY;

    private static final double LOOP_RADIUS = 24;

    private static int screenSize, graphSize;

    @Override
    public void initEngine(int screenSize, int graphSize) {
        AwtDAPI.screenSize = screenSize;
        AwtDAPI.graphSize = graphSize;
        AwtEngine.init(screenSize);
    }

    @Override
    public int getScreenSize() {
        return screenSize;
    }

    @Override
    public int getGraphSize() {
        return graphSize;
    }

    @Override
    public void drawPoint(double x, double y) {
        AwtEngine.drawPointLater(pointColor, x, y, pointRadius);
    }

    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        AwtEngine.drawLineLater(lineColor, new BasicStroke(lineWidth), x1, y1, x2, y2);
    }

    @Override
    public void drawLoop(double vx, double vy, double dirAngle) {
        AwtEngine.drawLoopLater(lineColor, new BasicStroke(lineWidth), vx, vy, dirAngle, LOOP_RADIUS);
    }

    @Override
    public void show() {
        AwtEngine.main(null);
    }
}
