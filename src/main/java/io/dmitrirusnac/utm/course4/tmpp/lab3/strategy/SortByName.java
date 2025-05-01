package io.dmitrirusnac.utm.course4.tmpp.lab3.strategy;

import io.dmitrirusnac.utm.course4.tmpp.lab3.model.Task;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortByName implements SortStrategy {
    public void sort(List<Task> tasks) {
        tasks.sort(Comparator.comparing(Task::getName));
    }
}
