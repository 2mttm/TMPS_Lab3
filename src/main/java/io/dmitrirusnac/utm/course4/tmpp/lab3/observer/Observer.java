package io.dmitrirusnac.utm.course4.tmpp.lab3.observer;
import io.dmitrirusnac.utm.course4.tmpp.lab3.model.Task;

import java.util.List;

public interface Observer {
    void update(List<Task> tasks);
}
