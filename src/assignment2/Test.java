package assignment2;

import java.awt.Component;

import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskListener;

public class Test implements Task,TaskListener{

	@Override
	public void taskChanged(Task t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taskCompleted(Task t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taskUncompleted(Task t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taskCreated(Task t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taskRemoved(Task t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTaskType() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setTaskListener(TaskListener t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TaskListener getTaskListener() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isComplete() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Component getGuiComponent() {
		// TODO Auto-generated method stub
		return null;
	}

}
