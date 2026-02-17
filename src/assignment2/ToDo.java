package assignment2;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
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
		
		
		JPanel panel1 = new JPanel(new BorderLayout());
		panel1.setLayout(new BoxLayout(panel1,1));
		//panel1.setSize(100,100);
		panel1.setBounds(0,0, 800, 600);
		panel1.setVisible(true);
		panel1.setBackground(Color.red);
		
		JPanel panel2 = new JPanel();
		
		
		panel2.setBounds(0,100, 50, 50);
		panel2.setVisible(true);
		panel2.setBackground(Color.green);
		
		frame.add(panel1);
		frame.add(panel2);
		JButton AddHomeTaskButton = new JButton("New Hometask");
		
		JButton AddStudyTaskButton = new JButton("New Studytask");
		//testButton.addActionListener(task.getTaskListener(){
		//testButton.addActionListener((ActionListener) listener)
		AddHomeTaskButton.addActionListener(new ActionListener() {
		public int distanceCounter;		

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						//distanceC
						Task task = new HomeTask();
						System.out.println("test");
						panel1.add(task.getGuiComponent());
						frame.revalidate();
						frame.repaint();
						panel1.revalidate();
						panel1.repaint();
					}
		});
		
		AddStudyTaskButton.addActionListener(new ActionListener() {
			public int distanceCounter;		

						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							//distanceC
							Task task = new StudyTask();
							System.out.println("test");
							panel1.add(task.getGuiComponent());
							frame.revalidate();
							frame.repaint();
							panel1.revalidate();
							panel1.repaint();
						}
			});
;
		
		
		panel2.add(AddHomeTaskButton,BorderLayout.NORTH);
		panel2.add(AddStudyTaskButton,BorderLayout.SOUTH);
		//TaskInputListener input = new TaskInputListener( task, null, null);
		//input.mousePressed(null);
		
		
	}
	
	}