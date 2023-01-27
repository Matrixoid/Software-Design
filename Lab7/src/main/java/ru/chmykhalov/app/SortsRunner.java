package ru.chmykhalov.app;

import ru.chmykhalov.app.arrays.ArraysCreator;
import ru.chmykhalov.app.sorts.BubbleSort;
import ru.chmykhalov.app.sorts.MergeSort;
import ru.chmykhalov.app.sorts.QuickSort;

public class SortsRunner {
    public void run() {
        ArraysCreator arraysCreator = new ArraysCreator();
        System.out.println("Merge sort started");
        new MergeSort().mergeSort(arraysCreator.createRandomArray(1000000), 1000000);
        System.out.println("Merge sort ended");
        System.out.println("Quick sort started");
        new QuickSort().quickSort(arraysCreator.createRandomArray(1000000), 0, 999999);
        System.out.println("Quick sort ended");
        System.out.println("Bubble sort started");
        new BubbleSort().bubbleSort(arraysCreator.createRandomArray(20000));
        System.out.println("Bubble sort ended");
    }
}
