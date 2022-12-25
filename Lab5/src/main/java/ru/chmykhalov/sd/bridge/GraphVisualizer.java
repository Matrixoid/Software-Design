package ru.chmykhalov.sd.bridge;

import ru.chmykhalov.sd.bridge.drawing.AwtDAPI;
import ru.chmykhalov.sd.bridge.drawing.DrawingAPI;
import ru.chmykhalov.sd.bridge.drawing.JavaFxDAPI;
import ru.chmykhalov.sd.bridge.graph.Graph;
import ru.chmykhalov.sd.bridge.graph.ListGraph;
import ru.chmykhalov.sd.bridge.graph.MatrixGraph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GraphVisualizer {

    private static final int SCREEN_SIZE = 800;
    private static final int GRAPH_SIZE = 500;
    private static final String RESOURCES_PATH = "src\\main\\resources\\ru\\chmykhalov\\sd\\bridge\\";

    public static void main(String[] args) {
        DrawingAPI drawingApi = getDrawingApiInstance(args[0]);
        Graph graph = getGraphInstance(args[1], drawingApi);
        String path = buildPath(args[2]);

        try (Scanner scanner = new Scanner(new File(path))) {
            graph.readGraph(scanner);

            drawingApi.initEngine(SCREEN_SIZE, GRAPH_SIZE);
            graph.drawGraph();
            drawingApi.show();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static DrawingAPI getDrawingApiInstance(String type) {
        switch (type) {
            case "jfx":
                return new JavaFxDAPI();
            case "awt":
                return new AwtDAPI();
            default:
                throw new IllegalArgumentException(
                        "Undefined drawing api: " + type + " (expected 'awt' or 'jfx')"
                );
        }
    }

    private static Graph getGraphInstance(String type, DrawingAPI drawingApi) {
        switch (type) {
            case "matrix":
                return new MatrixGraph(drawingApi);
            case "list":
                return new ListGraph(drawingApi);
            default:
                throw new IllegalArgumentException(
                        "Undefined graph format: " + type + " (expected 'matrix' or 'list')"
                );
        }
    }

    private static String buildPath(String filename) {
        return new File(RESOURCES_PATH + filename).getAbsolutePath();
    }
}
