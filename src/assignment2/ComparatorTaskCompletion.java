package assignment2;

import java.util.Comparator;
import se.his.it401g.todo.Task;

//Comparator used for sorting the completed tasks from the uncompleted tasks.
public class ComparatorTaskCompletion implements Comparator<Task> {

//    Called when the sortTaskCompletionButton is pressed. This sorts the  uncompleted tasks above the completed tasks. 
    @Override
    public int compare(Task task1, Task task2) {
        return Boolean.compare(task1.isComplete(), task2.isComplete());
    }
}