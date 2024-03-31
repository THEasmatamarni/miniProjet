package taches_rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TaskListServer {
    public static void main(String[] args) {
        try {
            TaskListService taskListService = new TaskListServiceImpl();
            LocateRegistry.createRegistry(1099); // Port RMI par défaut
            Naming.rebind("TaskListService", taskListService);
            System.out.println("TaskListService is running...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
