public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Task newTask = new Task ("пробная","ее описание",0,Status.NEW);
        Task someTask = new Task("вторая задачка", "ее какое-то описание",0,Status.NEW);
        final Task task = manager.createTask(newTask);
        final Task task2 = manager.createTask(someTask);
        final Task tasks1 = manager.receiveTask(task.getId());
        if(!task.equals(tasks1)){
            System.out.println("Ошибка ой ей, нет  задачи c id "+task.getId() );
        }
        System.out.println(manager.receiveTasks());
        manager.removeTask(task.getId());



    }
}
