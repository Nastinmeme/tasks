import java.util.ArrayList;
public class Epic extends Task{
    private ArrayList <Integer> substasks;
    public Epic(String taskName, String taskDescription, int id, String status ){
        super(taskName, taskDescription, id,status);
    }

    public Epic(String taskName, String taskDescription, int id, String status ,ArrayList<Integer> substasks) {
        super(taskName, taskDescription, id,status);
        this.substasks = substasks;
    }

    public ArrayList<Integer> getSubstasks() {
        return substasks;
    }

    public void setSubstasks(ArrayList<Integer> substasks) {
        this.substasks = substasks;
    }
}
