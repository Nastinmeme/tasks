import java.util.ArrayList;
import java.util.HashMap;

public class Manager {

    private final HashMap<Integer, Task> tasks = new HashMap<>();
    private final HashMap<Integer, Subtask> subtasksAll = new HashMap<>();

    private final HashMap<Integer, Epic> epics = new HashMap<>();
    int genId = 0;

    /**
     * Методы для задач
     *
     *
    1.+
    Получение списка всех задач
     */
    public ArrayList<Task> findeTasks() {

        return new ArrayList<>(tasks.values());
    }

    /**2+
    Удаление задач
     */

    public void deleteAllTasks() {
        tasks.clear();
    }

    /**3+
      Получение по идентификатору
     */
    public Task findeTask(int id) {
        return tasks.get(id);

    }

    /**4+
     Создание задачи
     */
    public Task createTask(Task task) {
        Task value = new Task(task.getTaskName(),task.getTaskDescription(),task.getId(),Status.NEW);
        task.setId(++genId);
        tasks.put(task.getId(), value);
         return task;
    }

    /**5+
    Обновление задачи

     */

    public void reTask(Task task) {
        if (!tasks.containsKey(task.getId())) {
            return;
        } else if (task.getStatus() == Status.NEW) {
            task.setStatus(Status.IN_PROGRESS);
        } else if (task.getStatus() == Status.IN_PROGRESS) {
            task.setStatus(Status.DONE);
        }
        tasks.put(task.getId(), task);

    }

    /**6+
    Удаление задачи по ИД
     */
    public void removeTask(int id) {
        tasks.remove(id);

    }

    /**
    Методы для Эпиков
     */

    /**7+
    Получение всех эпиков
     */
    public ArrayList<Epic> findeEpics() {

        return new ArrayList<>(epics.values());
    }

    /**8+
        удаление всех эпиков
         */
    public void deleteAllEpics() {
        epics.clear();
    }

    /**9+
        Получение эпика по ид
         */
    public Epic findeEpic(int id) {
        return epics.get(id);

    }

    /**10+
        Создание эпика
         */
    public Epic createEpic(Epic epic) {
        Epic value = new Epic(epic.getTaskName(), epic.getTaskDescription(), epic.getId(), Status.NEW,epic.getSubstasks());
        epic.setId(++genId);
        epics.put(epic.getId(), value);
return epic;
    }

    /**11+
        Обновление эпика
         */
    public void reEpic(Epic epic) {
       for(Subtask sub: epic.getSubstasks()){
           if(sub.getStatus()=="NEW"){

           }
       }
    }

    /**12+
    Удаление эпика по ид.
     */
    public void removeEpicId(int id) {
        epics.remove(id);

    }

    private void changeStatus(Epic epic) {
        for (Subtask subt : epic.getSubstasks()) {

            if (subt == null || subt.getStatus() == "NEW") {
                System.out.println("новый");
            } else if (subt.getStatus() == "DONE") {
                subt.setStatus(Status.DONE);
                System.out.println("все готово");
            } else {
                subt.setStatus(Status.IN_PROGRESS);
                System.out.println("в процессе");
            }
        }

    }

     /** 1+
    Методы для Подзадач
     */


    /**13+
    Получение всех подзадач
     */

    public ArrayList<Subtask> findeSubtasks() {

        return new ArrayList<>(subtasksAll.values());

    }

    /**14+
        удаление всех подзадач
         */

    public void deleteAllSubtasks() {
        subtasksAll.clear();
    }

    /**15+
        Получение подзадач по ид
         */
    public Subtask findeSubtask(int id) {
        return subtasksAll.get(id);
    }

    /**16
        Создание подзадач
         */
    public Subtask createSubtask(Subtask subtask) {
        if (subtask==null) {
            System.out.println("Нет значений для задачи");
        } else {
            Subtask value = new Subtask(subtask.getTaskName(), subtask.getTaskDescription(), subtask.getId(),
                    Status.NEW, 0);
            subtask.setId(++genId);
            Epic epic = findeEpic(subtask.getEpicId());
            ArrayList<Subtask> subEpic;

         if (epic==null) {
             System.out.println("Нет значений для эпика");
         }else{
           if (epic.getSubstasks() == null) {
                subEpic = new ArrayList<>();
                epic.setSubstasks(subEpic);
            } else {
                subEpic = epic.getSubstasks();
                subEpic.add(value);
                epic.setSubstasks(subEpic);
           }}


            subtasksAll.put(subtask.getId(), value);
        }
        return subtask;

    }

    /**17
        Обновление подзадач

         */
    public void reSubtask(Subtask subtask) {
        if (!subtasksAll.containsKey(subtask.getId())) {
            return;
        } else if (subtask.getStatus() == Status.NEW) {
            subtask.setStatus(Status.IN_PROGRESS);
        } else if (subtask.getStatus() == Status.IN_PROGRESS) {
            subtask.setStatus(Status.DONE);
        }
        tasks.put(subtask.getId(), subtask);
        Epic epic = findeEpic(subtask.getEpicId());
       changeStatus(epic);
    }


    /** 18+
    Удаление подзадач по ид.
     */

    public void removeSubtaskId(int id) {
        subtasksAll.remove(id);

    }
    /**
     * Получение подзадач по эпику
     */
    public ArrayList<Task> findSubtaskEpic(int epicId){
        return new ArrayList<>();
    }
}
