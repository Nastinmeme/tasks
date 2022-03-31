public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager();

        Task newTask = new Task ("пробная","ее описание", manager.genId, Status.NEW);
        Task someTask = new Task("вторая задачка", "ее какое-то описание",manager.genId,Status.NEW);
        manager.createTask(newTask);
        manager.createTask(someTask);

        manager.removeTask(someTask.getId());
        Epic newEpic = new Epic("первый эпик","опискание эпика,нужно ли оно?",0,Status.NEW);
        manager.createEpic(newEpic);
        Epic newEpic2 = new Epic("2 эпик","опискание эпика,нужно ли оно?",0,Status.NEW);
        manager.createEpic(newEpic2);
        Subtask newSub = new Subtask("Первый саб", "опаисание странного саба",0,Status.NEW,newEpic.getId());
        manager.createSubtask(newSub);
        Subtask newSub2 = new Subtask("2 саб", "опаисание странного саба",0,Status.NEW,newEpic.getId());
        manager.createSubtask(newSub2);

       manager.reSubtask(newSub);





    }
}
