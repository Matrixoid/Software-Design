package ru.chmykhalov.sd.bridge.drawing;

import javafx.scene.paint.Color;
import ru.chmykhalov.sd.bridge.engine.JavaFxEngine;

import java.awt.*;

import static ru.chmykhalov.sd.bridge.engine.JavaFxEngine.getGraphicsContext;

public class JavaFxDAPI implements DrawingAPI{

    private static final double pointRadius = 16;
    private static final Color pointColor = Color.RED;

    private static final double lineWidth = 3;
    private static final Color lineColor = Color.BLACK;

    private static final double LOOP_RADIUS = 24;

    private static int screenSize, graphSize;

    @Override
    public void initEngine(int screenSize, int graphSize) {
        JavaFxDAPI.screenSize = screenSize;
        JavaFxDAPI.graphSize = graphSize;
        JavaFxEngine.init(screenSize);
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
        getGraphicsContext().setFill(pointColor);
        getGraphicsContext().fillOval(x - pointRadius / 2, y - pointRadius / 2, pointRadius, pointRadius);
    }

    @Override
    public void drawLine(double x1, double y1, double x2, double y2) {
        getGraphicsContext().setStroke(lineColor);
        getGraphicsContext().setLineWidth(lineWidth);
        getGraphicsContext().strokeLine(x1, y1, x2, y2);
    }

    @Override
    public void drawLoop(double vx, double vy, double dirAngle) {
        getGraphicsContext().setStroke(lineColor);
        getGraphicsContext().setLineWidth(lineWidth);
        getGraphicsContext().strokeOval(
                vx - LOOP_RADIUS / 2 + Math.cos(dirAngle) * LOOP_RADIUS / 2,
                vy - LOOP_RADIUS / 2 + Math.sin(dirAngle) * LOOP_RADIUS / 2,
                LOOP_RADIUS, LOOP_RADIUS
        );
    }

    @Override
    public void show() {
        JavaFxEngine.main(null);
    }
}
