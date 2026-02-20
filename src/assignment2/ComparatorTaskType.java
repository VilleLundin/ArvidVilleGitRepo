package assignment2;



import java.util.Comparator;

import se.his.it401g.todo.Task;

public class ComparatorTaskType implements Comparator<Task> {

	@Override
	public int compare(Task o1, Task o2) {
		// TODO Auto-generated method stub
		return o1.getText().compareToIgnoreCase(o2.getText());
	}

	

}
