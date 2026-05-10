package assignment2;

import java.util.Comparator;
import se.his.it401g.todo.Task;

//Comparator used for sorting tasks by different task types.
public class ComparatorTaskType implements Comparator<Task> {

//    Called when the sortTaskTypeButton is pressed. Orders each tasks with the same tasktype close to the same tasktypes.
    @Override
    public int compare(Task task1, Task task2) {
        return task1.getTaskType().compareToIgnoreCase(task2.getTaskType());
    }
}