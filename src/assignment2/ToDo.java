package assignment2;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskInputListener;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.TaskListener;

public class ToDo {

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		//JLabel label = new JLabel();
		
		
		
		
		Task task = new HomeTask();
		//Task task2 = new StudyTask();
		frame.add(task.getGuiComponent());
		TaskInputListener taskListener = new TaskInputListener(task, null, null);
		
		//task.task()
		
		frame.setBounds(100, 100, 400, 100);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}
}