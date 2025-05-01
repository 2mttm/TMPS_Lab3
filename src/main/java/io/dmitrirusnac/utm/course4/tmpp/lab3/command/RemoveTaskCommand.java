package io.dmitrirusnac.utm.course4.tmpp.lab3.command;

import io.dmitrirusnac.utm.course4.tmpp.lab3.TaskManager;
import io.dmitrirusnac.utm.course4.tmpp.lab3.model.Task;

public class RemoveTaskCommand implements Command {
    private final TaskManager manager;
    private final Task task;

    public RemoveTaskCommand(TaskManager manager, Task task) {
        this.manager = manager;
        this.task = task;
    }

    public void execute() {
        manager.removeTask(task);
    }

    public void undo() {
        manager.addTask(task);
    }
}