package io.dmitrirusnac.utm.course4.tmpp.lab3.observer;

import io.dmitrirusnac.utm.course4.tmpp.lab3.model.Task;

import java.util.List;

public class TaskUI implements Observer {
    public void update(List<Task> tasks) {
        System.out.println("[UI] Displaying tasks:");
        tasks.forEach(System.out::println);
    }
}