package io.dmitrirusnac.utm.course4.tmpp.lab3;

import io.dmitrirusnac.utm.course4.tmpp.lab3.model.Task;
import io.dmitrirusnac.utm.course4.tmpp.lab3.observer.Observer;
import io.dmitrirusnac.utm.course4.tmpp.lab3.observer.Subject;
import io.dmitrirusnac.utm.course4.tmpp.lab3.strategy.SortStrategy;

import java.util.ArrayList;
import java.util.List;

public class TaskManager implements Subject {
    private List<Task> tasks = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();
    private SortStrategy sortStrategy;

    public void setSortStrategy(SortStrategy strategy) {
        this.sortStrategy = strategy;
    }

    public Task getTaskByName(String name) {
        for (Task t : tasks) {
            if (t.getName().equalsIgnoreCase(name)) {
                return t;
            }
        }
        return null;
    }

    public void sortTasks() {
        if (sortStrategy != null) {
            sortStrategy.sort(tasks);
            notifyObservers();
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        notifyObservers();
    }

    public void removeTask(Task task) {
        tasks.remove(task);
        notifyObservers();
    }

    public void addObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(new ArrayList<>(tasks)); // send copy
        }
    }
}