package io.dmitrirusnac.utm.course4.tmpp.lab3.observer;


import io.dmitrirusnac.utm.course4.tmpp.lab3.model.Task;

import java.util.List;

public class TaskLogger implements Observer {
    public void update(List<Task> tasks) {
        System.out.println("[Logger] Task list updated: " + tasks);
    }
}