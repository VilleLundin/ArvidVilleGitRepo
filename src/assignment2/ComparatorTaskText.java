package assignment2;

import java.util.Comparator;
import se.his.it401g.todo.Task;

public class ComparatorTaskText implements Comparator<Task> {

	@Override
	public int compare(Task task1, Task task2) {
		return task1.getText().compareToIgnoreCase(task2.getText());
	}
}