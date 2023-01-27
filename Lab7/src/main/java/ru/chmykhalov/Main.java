package ru.chmykhalov;

import ru.chmykhalov.app.SortsRunner;
import ru.chmykhalov.profiler.Profiler;

public class Main {
    public static void main(String[] args) {
        System.out.println(
                Profiler.use("ru.chmykhalov.app", () -> {
                    new SortsRunner().run();
                })
        );
    }
}
