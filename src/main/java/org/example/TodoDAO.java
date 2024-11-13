package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TodoDAO {
    private static final String URL = "jdbc:sqlserver://localhost:1433;database=TODO;integratedSecurity=true;encrypt=false;trustServerCertificate=true;";
    private static final Logger LOGGER = Logger.getLogger(TodoDAO.class.getName());

    public void create(String task) {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO Todo (task) VALUES (?)")) {
            pstmt.setString(1, task);
            pstmt.executeUpdate();
            LOGGER.info("Todo created: " + task);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error creating todo: " + task, e);
        }
    }

    public List<Todo> readAll() {
        List<Todo> todos = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {

            LOGGER.info("Fetching all todos...");
            Thread.sleep(1300);

            try (ResultSet rs = stmt.executeQuery("SELECT * FROM Todo")) {
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String task = rs.getString("task");
                    boolean completed = rs.getBoolean("completed");
                    todos.add(new Todo(id, task, completed));
                }
                LOGGER.info("Todos fetched successfully.");
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error reading todos", e);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.log(Level.WARNING, "Thread was interrupted during sleep.", e);
        }
        return todos;
    }

    public void update(int id, String newTask) {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement("UPDATE Todo SET task = ? WHERE id = ?")) {
            pstmt.setString(1, newTask);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            LOGGER.info("Todo updated: " + newTask);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error updating todo with ID: " + id, e);
        }
    }

    public void delete(int id) {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM Todo WHERE id = ?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            LOGGER.info("Todo deleted with ID: " + id);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error deleting todo with ID: " + id, e);
        }
    }

    public void completeTask(int id) {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement("UPDATE Todo SET completed = ? WHERE id = ?")) {
            pstmt.setBoolean(1, true);
            pstmt.setInt(2, id);
            pstmt.executeUpdate();
            LOGGER.info("Todo with ID " + id + " marked as completed.");
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error marking todo with ID: " + id + " as completed", e);
        }
    }
}
