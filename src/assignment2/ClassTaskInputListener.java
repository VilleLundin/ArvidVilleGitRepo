package assignment2;

import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.Task;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.TaskListener;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskInputListener;
import se.his.it401g.todo.TaskListener;

public class  ClassTaskInputListener extends TaskInputListener implements KeyListener, MouseListener, ActionListener, ItemListener{

	public ClassTaskInputListener(Task task, JTextField text, JLabel textLabel) {
		super(task, text, textLabel);
		
		TaskInputListerner.task = task;
		this.// TODO Auto-generated constructor stub
	}
	

	
	
	
	
}
