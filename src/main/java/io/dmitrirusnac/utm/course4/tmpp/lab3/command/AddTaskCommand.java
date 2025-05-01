package io.dmitrirusnac.utm.course4.tmpp.lab3.command;

import io.dmitrirusnac.utm.course4.tmpp.lab3.TaskManager;
import io.dmitrirusnac.utm.course4.tmpp.lab3.model.Task;

public class AddTaskCommand implements Command {
    private final TaskManager manager;
    private final Task task;

    public AddTaskCommand(TaskManager manager, Task task) {
        this.manager = manager;
        this.task = task;
    }

    public void execute() {
        manager.addTask(task);
    }

    public void undo() {
        manager.removeTask(task);
    }
}