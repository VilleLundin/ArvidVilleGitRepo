package assignment2;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;
import javax.swing.JButton;
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
		
		
	
		
		
		
		//Task task = new HomeTask();
		//Task task2 = new StudyTask();
		//3task.getTaskListener(remove));
		//frame.add(task.getGuiComponent());
		//frame.setLayout(null)
		
		
		//TaskInputListener taskListener = new TaskInputListener(task, null, null);
		
		//task.task()
		
		//System.out.println(listener1);
		
		frame.setBounds(100, 100, 1000, 600);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(50, 50, 1000, 100);
		panel1.setVisible(true);
		JButton testButton = new JButton("New Hometask");
		//testButton.addActionListener(task.getTaskListener(){
		//testButton.addActionListener((ActionListener) listener)
		testButton.addActionListener(new ActionListener() {
				

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						Task task = new HomeTask();
						System.out.println("test");
						frame.add(task.getGuiComponent());
						frame.revalidate();
						frame.repaint();
						panel1.revalidate();
						panel1.repaint();
					}
		});
		
		
;
		
		
		frame.add(testButton,BorderLayout.NORTH);
		//TaskInputListener input = new TaskInputListener( task, null, null);
		//input.mousePressed(null);
		
		
	}
	
	}