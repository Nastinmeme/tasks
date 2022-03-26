public class Subtask extends Task{
   private int epicId;
  public Subtask(String taskName, String taskDescription, int id, String status ){
      super(taskName, taskDescription, id,status);
  }

    public Subtask(String taskName, String taskDescription, int id, String status,int epicId) {
        super(taskName, taskDescription, id,status);
        this.epicId = epicId;
    }

    public int getEpicId() {
        return epicId;
    }

    public void setEpicId(int epicId) {
        this.epicId = epicId;
    }
}
