import java.util.ArrayList;

public class Epic extends Task {
    private ArrayList<Subtask> substasks;

    public Epic(String taskName, String taskDescription, int id, String status, ArrayList<Subtask> substasks) {
        super(taskName, taskDescription, id, status);
        this.substasks = substasks;
    }

    public Epic(String taskName, String taskDescription, int id, String status) {
        super(taskName, taskDescription, id, status);
    }


    public ArrayList<Subtask> getSubstasks() {

        return substasks;
    }

    public void setSubstasks(ArrayList<Subtask> substasks) {

        this.substasks = substasks;
    }
}
