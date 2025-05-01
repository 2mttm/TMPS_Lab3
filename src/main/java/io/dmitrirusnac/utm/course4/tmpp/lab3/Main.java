package io.dmitrirusnac.utm.course4.tmpp.lab3;

import io.dmitrirusnac.utm.course4.tmpp.lab3.command.AddTaskCommand;
import io.dmitrirusnac.utm.course4.tmpp.lab3.command.CommandManager;
import io.dmitrirusnac.utm.course4.tmpp.lab3.command.RemoveTaskCommand;
import io.dmitrirusnac.utm.course4.tmpp.lab3.model.Task;
import io.dmitrirusnac.utm.course4.tmpp.lab3.observer.TaskLogger;
import io.dmitrirusnac.utm.course4.tmpp.lab3.observer.TaskUI;
import io.dmitrirusnac.utm.course4.tmpp.lab3.strategy.SortByName;
import io.dmitrirusnac.utm.course4.tmpp.lab3.strategy.SortByPriority;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();
        CommandManager commandManager = new CommandManager();
        Scanner scanner = new Scanner(System.in);

        // Добавляем наблюдателей
        manager.addObserver(new TaskLogger());
        manager.addObserver(new TaskUI());

        boolean running = true;

        System.out.println("=== Task Manager ===");

        while (running) {
            System.out.println("\nВыберите действие:");
            System.out.println("1. Добавить задачу");
            System.out.println("2. Удалить задачу");
            System.out.println("3. Сортировать по имени");
            System.out.println("4. Сортировать по приоритету");
            System.out.println("5. Undo");
            System.out.println("6. Показать список задач");
            System.out.println("0. Выход");

            System.out.print("Ваш выбор: ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.print("Введите имя задачи: ");
                    String name = scanner.nextLine();
                    System.out.print("Введите приоритет (целое число): ");
                    int priority = Integer.parseInt(scanner.nextLine());
                    Task newTask = new Task(name, priority);
                    commandManager.executeCommand(new AddTaskCommand(manager, newTask));
                    break;
                case "2":
                    System.out.print("Введите имя задачи для удаления: ");
                    String delName = scanner.nextLine();
                    Task toRemove = manager.getTaskByName(delName);
                    if (toRemove != null) {
                        commandManager.executeCommand(new RemoveTaskCommand(manager, toRemove));
                    } else {
                        System.out.println("Задача не найдена.");
                    }
                    break;
                case "3":
                    manager.setSortStrategy(new SortByName());
                    manager.sortTasks();
                    break;
                case "4":
                    manager.setSortStrategy(new SortByPriority());
                    manager.sortTasks();
                    break;
                case "5":
                    commandManager.undoLast();
                    break;
                case "6":
                    manager.notifyObservers(); // вручную "обновим" интерфейс
                    break;
                case "0":
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }

        System.out.println("Завершение программы...");
    }
}