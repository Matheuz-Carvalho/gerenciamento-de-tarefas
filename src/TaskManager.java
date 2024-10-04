package src;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TaskManager {
    private List<Task> tasks = new ArrayList<>();

    public void addTask(Task task) {
        tasks.add(task);
        Collections.reverse(tasks);
    }

    public void removeTask(int taskId) {
        if (taskId >= 0 && taskId < tasks.size()) {
            tasks.remove(taskId);
            System.out.println("Tarefa removida com sucesso.");
        } else {
            System.out.println("ID de tarefa inválido.");
        }
    }

    public void updateTask(int taskId, Task updatedTask) {
        if (taskId >= 0 && taskId < tasks.size()) {
            tasks.set(taskId, updatedTask);
            System.out.println("Tarefa atualizada com sucesso.");
        } else {
            System.out.println("ID de tarefa inválido.");
        }
    }

    public List<Task> getAllTasks() {
        return tasks;
    }

    public List<Task> getPendingTasks() {
        return tasks.stream().filter(t -> !t.isConcluida()).collect(Collectors.toList());
    }

    public void markTaskAsCompleted(int taskId) {
        if (taskId >= 0 && taskId < tasks.size()) {
            Task task = tasks.get(taskId);
            task.setCompleted(true);
            System.out.println("Tarefa marcada como concluída.");
        } else {
            System.out.println("ID de tarefa inválido.");
        }
    }

    public void listTasks(List<Task> tasksToDisplay) {
        if (tasksToDisplay.isEmpty()) {
            System.out.println("Nenhuma tarefa encontrada.");
        } else {
            for (int i = 0; i < tasksToDisplay.size(); i++) {
                System.out.println(i + " - " + tasksToDisplay.get(i).toString());
            }
        }
    }
}
