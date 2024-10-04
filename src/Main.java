package src;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT);

        while (running) {
            System.out.println("\n Sistema de Gerenciamento de Tarefas ");
            System.out.println("1. Adicionar nova tarefa");
            System.out.println("2. Listar todas as tarefas");
            System.out.println("3. Listar tarefas pendentes");
            System.out.println("4. Atualizar tarefa");
            System.out.println("5. Remover tarefa");
            System.out.println("6. Marcar tarefa como concluída");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");

            int option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    System.out.print("Título da tarefa: ");
                    String title = scanner.nextLine();
                    System.out.print("Descrição da tarefa: ");
                    String description = scanner.nextLine();

                    System.out.print("Data de vencimento (DD/MM/YYYY): ");
                    String dueDateString = scanner.nextLine();
                    LocalDate dueDate = LocalDate.parse(dueDateString, formatter);

                    System.out.print("Prioridade (Baixa, Média, Alta): ");
                    String priority = scanner.nextLine();

                    Task task = new Task(title, description, dueDate, priority);
                    taskManager.addTask(task);
                    System.out.println("Tarefa adicionada com sucesso.");
                    break;

                case 2:
                    System.out.println("\n Todas as Tarefas ");
                    taskManager.listTasks(taskManager.getAllTasks());
                    break;

                case 3:
                    System.out.println("\n Tarefas Pendentes ");
                    taskManager.listTasks(taskManager.getPendingTasks());
                    break;

                case 4:
                    System.out.print("ID da tarefa a atualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Novo título da tarefa: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("Nova descrição da tarefa: ");
                    String newDescription = scanner.nextLine();

                    System.out.print("Nova data de vencimento (DD/MM/YYYY): ");
                    String newDueDateString = scanner.nextLine();
                    LocalDate newDueDate = LocalDate.parse(newDueDateString, formatter);

                    System.out.print("Nova prioridade (Baixa, Média, Alta): ");
                    String newPriority = scanner.nextLine();

                    Task updatedTask = new Task(newTitle, newDescription, newDueDate, newPriority);
                    taskManager.updateTask(updateId, updatedTask);
                    break;

                case 5:
                    System.out.print("ID da tarefa a remover: ");
                    int removeId = scanner.nextInt();
                    taskManager.removeTask(removeId);
                    break;

                case 6:
                    System.out.print("ID da tarefa a marcar como concluída: ");
                    int completeId = scanner.nextInt();
                    taskManager.markTaskAsCompleted(completeId);
                    break;

                case 7:
                    running = false;
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
        scanner.close();
    }
}
