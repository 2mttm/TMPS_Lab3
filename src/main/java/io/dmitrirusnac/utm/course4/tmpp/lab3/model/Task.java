package io.dmitrirusnac.utm.course4.tmpp.lab3.model;

public record Task(String name, int priority) {

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + "}";
    }
}
