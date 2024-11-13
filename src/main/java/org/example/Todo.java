package org.example;

public class Todo {
    private final int id;
    private final String task;
    private final boolean completed;

    public Todo(int id, String task, boolean completed) {
        this.id = id;
        this.task = task;
        this.completed = completed;
    }

    @Override
    public String toString() {
        String completado = "Verdadero";
        if (!completed) {
            completado = "Falso";
        }
        return "\n" +
                "Número tarea: " + id + "\n" +
                "Tarea: " + task + "\n" +
                "Completado?: " + completado;

    }
}