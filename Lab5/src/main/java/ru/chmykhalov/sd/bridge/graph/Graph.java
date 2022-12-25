package ru.chmykhalov.sd.bridge.graph;

import ru.chmykhalov.sd.bridge.drawing.DrawingAPI;

import java.util.Scanner;

public abstract class Graph {

    protected DrawingAPI drawingApi;

    public Graph(DrawingAPI drawingApi) {
        this.drawingApi = drawingApi;
    }

    public abstract void readGraph(Scanner scanner);

    public abstract void drawGraph();
}
