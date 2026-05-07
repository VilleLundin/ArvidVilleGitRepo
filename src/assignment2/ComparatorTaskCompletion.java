package assignment2;

import java.util.Comparator;
import se.his.it401g.todo.Task;

public class ComparatorTaskCompletion implements Comparator<Task> {

	@Override
	public int compare(Task task1, Task task2) {
		return Boolean.compare(task1.isComplete(), task2.isComplete());
	}
}