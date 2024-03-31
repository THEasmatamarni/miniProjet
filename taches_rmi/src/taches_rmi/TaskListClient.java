package taches_rmi;

import java.rmi.Naming;
import java.util.List;

public class TaskListClient {
    public static void main(String[] args) {
        try {
            TaskListService taskListService = (TaskListService) Naming.lookup("rmi://localhost/TaskListService");

            // Ajouter une nouvelle tâche
            taskListService.addTask("Faire les courses");

            // Récupérer la liste complète des tâches
            List<String> tasks = taskListService.getTaskList();
            System.out.println("Tasks:");
            for (String task : tasks) {
                System.out.println("- " + task);
            }

            // Supprimer une tâche existante
            taskListService.removeTask("Faire les courses");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
