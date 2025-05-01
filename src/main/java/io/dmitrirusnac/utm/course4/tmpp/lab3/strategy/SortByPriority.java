package io.dmitrirusnac.utm.course4.tmpp.lab3.strategy;

import io.dmitrirusnac.utm.course4.tmpp.lab3.model.Task;

import java.util.Comparator;
import java.util.List;

public class SortByPriority implements SortStrategy {
    public void sort(List<Task> tasks) {
        tasks.sort(Comparator.comparingInt(Task::getPriority));
    }
}
