package assignment2;

import java.util.Comparator;
import se.his.it401g.todo.Task;

//Comparator used for sorting tasks by alphabetic order.

public class ComparatorTaskText implements Comparator<Task> {

//    Called when the sortAlphabeticalButton is pressed. Compares the text in each task that the user have written,
//    in a alphabetic order.

    @Override
    public int compare(Task task1, Task task2) {
        return task1.getText().compareToIgnoreCase(task2.getText());
    }
}