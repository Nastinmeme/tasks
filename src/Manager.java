import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private HashMap<Integer, Task> tasks = new HashMap<>();
    int genId = 0;
    //3*6+1

    public ArrayList<Task> receiveTasks() {
        return new ArrayList<>(tasks.values());
    }

    public void deleteAllTasks() {
        tasks.clear();
    }

    public Task receiveTask(int id) {
        return tasks.get(id);

    }

    public Task createTask(Task task) {

        task.setId(++genId);
        tasks.put(task.getId(), task);
        return task;

    }

    public void reTask(Task task) {
        //  Task task1 = tasks.get(task.getId());
        if (!tasks.containsKey(task.getId())) {
            return;
        }
        tasks.put(task.getId(), task);
    }

    public void removeTask(int id) {
        tasks.remove(id);

    }
}
