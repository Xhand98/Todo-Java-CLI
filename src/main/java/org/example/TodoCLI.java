package org.example;

import java.util.List;
import java.util.Scanner;

public class TodoCLI {
    private final TodoDAO todoDAO = new TodoDAO();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        TodoCLI cli = new TodoCLI();
        System.out.println("Welcome to the Todo CLI!");
        cli.showMenu();
    }

    public void showMenu() {
        while (true) {
            System.out.println("\nTodo List:");
            System.out.println("1. Create Todo");
            System.out.println("2. View Todos");
            System.out.println("3. Update Todo");
            System.out.println("4. Delete Todo");
            System.out.println("5. Complete Task");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter todo task: ");
                    String task = scanner.nextLine();
                    todoDAO.create(task);
                    break;
                case 2:
                    List<Todo> todos = todoDAO.readAll();
                    System.out.println("Your Todos:");
                    for (Todo todo : todos) {
                        System.out.println(todo);
                    }
                    break;
                case 3:
                    System.out.print("Enter todo ID to update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new task: ");
                    String newTask = scanner.nextLine();
                    todoDAO.update(updateId, newTask);
                    break;
                case 4:
                    System.out.print("Enter todo ID to delete: ");
                    int deleteId = scanner.nextInt();
                    todoDAO.delete(deleteId);
                    break;
                case 5:
                    System.out.print("Enter todo ID to complete: ");
                    int taskId = scanner.nextInt();
                    todoDAO.completeTask(taskId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }
}
