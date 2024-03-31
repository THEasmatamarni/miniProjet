package taches_rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TaskListServiceImpl extends UnicastRemoteObject implements TaskListService {
    private List<String> tasks;

    public TaskListServiceImpl() throws RemoteException {
        tasks = new ArrayList<>();
    }

    @Override
    public void addTask(String task) throws RemoteException {
        tasks.add(task);
        System.out.println("Task added: " + task);
    }

    @Override
    public void removeTask(String task) throws RemoteException {
        if (tasks.remove(task)) {
            System.out.println("Task removed: " + task);
        } else {
            System.out.println("Task not found: " + task);
        }
    }

    @Override
    public List<String> getTaskList() throws RemoteException {
        return new ArrayList<>(tasks);
    }
}

