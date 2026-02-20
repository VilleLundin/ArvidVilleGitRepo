package assignment2;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

import se.his.it401g.todo.HomeTask;
import se.his.it401g.todo.Task;
import se.his.it401g.todo.TaskInputListener;
import se.his.it401g.todo.StudyTask;
import se.his.it401g.todo.TaskListener;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class ToDo implements TaskListener {
	
	private JPanel panel1;
	private LinkedList<Task> listOfTasks;
	private LinkedList<Task> listOfCompletedTasks;
	private JLabel status;
	private int totalTasksInt;
	private int completedTasksInt;
	private String statusText;
	private int[] typeArray;
	private int i;
//	private MenuComponent task;
//	private Container frame;
	private Task task;

	
	
	private void rebuildTaskPanel() {
	    panel1.removeAll();

	    for (Task t : listOfTasks) {
	        panel1.add(t.getGuiComponent());
	    }

	    panel1.revalidate();
	    panel1.repaint();
	}
	
	
	
	public ToDo() {
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
		
//		frame.setBounds(100, 100, 1000, 600);
//		frame.setVisible(true);
//		
//		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		
//		
//		JPanel panel1 = new JPanel(new BorderLayout());
//		panel1.setLayout(new BoxLayout(panel1,1));
//		//panel1.setSize(100,100);
//		panel1.setBounds(200, 100, 800, 600);
//		panel1.setVisible(true);
//		panel1.setBackground(Color.red);
//		
//		JPanel panel2 = new JPanel(new BorderLayout());
//		panel2.setLayout(new BoxLayout(panel2,0));
//		
//		
//		panel2.setBounds(0, 0, 0, 0);
//		panel2.setVisible(true);
//		panel2.setSize(1, 1);
//		panel2.setBackground(Color.green);
//		
//		frame.add(panel1);
//		frame.add(panel2);
//		
//		
//		JButton AddHomeTaskButton = new JButton("New Hometask");
//		
//		JButton AddStudyTaskButton = new JButton("New Studytask");
//		//testButton.addActionListener(task.getTaskListener(){
//		//testButton.addActionListener((ActionListener) listener)
//		
//		
//		
//		AddHomeTaskButton.addActionListener(new ActionListener() {
//		public int distanceCounter;		
//
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						// TODO Auto-generated method stub
//						//distanceC
//						Task task = new HomeTask();
//						task.getTaskListener();
//						System.out.println("test");
//						panel1.add(task.getGuiComponent());
//						frame.revalidate();
//						frame.repaint();
//						panel1.revalidate();
//						panel1.repaint();
//					}
//		});
//		
//		AddStudyTaskButton.addActionListener(new ActionListener() {
//			public int distanceCounter;		
//
//						@Override
//						public void actionPerformed(ActionEvent e) {
//							// TODO Auto-generated method stub
//							//distanceC
//							Task task = new StudyTask();
//							System.out.println("test");
//							panel1.add(task.getGuiComponent());
//							frame.revalidate();
//							frame.repaint();
//							panel1.revalidate();
//							panel1.repaint();
//						}
//			});
//;
//		
//		
//		panel2.add(AddHomeTaskButton);
//		panel2.add(AddStudyTaskButton);
//		//TaskInputListener input = new TaskInputListener( task, null, null);
//		//input.mousePressed(null);
//		
//	}	
	
	
		
		
		
		
		
		
		
		
		
		
	
		frame.setSize(750, 550);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
	
	panel1 = new JPanel(new BorderLayout());
	panel1.setBackground(Color.green);
//	panel1.setBounds(0, 80, 737, 433);
	panel1.setLayout(new BoxLayout(panel1,1));
		
	JPanel panel2 = new JPanel(new BorderLayout());
	panel2.setBackground(Color.red);
	panel2.setBounds(0, 0, 737, 80);
	panel2.setLayout(new BoxLayout(panel2, 0));
	
	JScrollPane scroll = new JScrollPane(panel1);
	frame.add(scroll, BorderLayout.CENTER);
	frame.add(panel2, BorderLayout.NORTH);
	
	JButton AddHomeTaskButton = new JButton("New Home task");
	JButton AddStudyTaskButton = new JButton("New Study task");
	JButton AddCustomTaskButton = new JButton("New Detailed task");
	
	status = new JLabel(completedTasksInt + " out of " + totalTasksInt + " completed"); //+ listOfCompletedTasks.indexOf(task));
	statusText = new String(completedTasksInt + " out of " + totalTasksInt + " completed");
	
	listOfTasks = new LinkedList<Task>();
	listOfCompletedTasks = new LinkedList<Task>();
	totalTasksInt = listOfTasks.indexOf(task)+1;
	
	
	panel2.add(AddHomeTaskButton);
	panel2.add(AddStudyTaskButton);
	panel2.add(AddCustomTaskButton);
	panel2.add(status);
	
	scroll.setViewportView(panel1);
	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	

	
		AddHomeTaskButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Task task = new HomeTask();
				listOfTasks.addLast(task);
				listOfCompletedTasks.addLast(task);
//				typeArray[i++]=1;
				totalTasksInt++;
				status.setText(completedTasksInt + " out of " + totalTasksInt + " tasks completed");
//				System.out.println("total tasks: " + listOfTasks.indexOf(task));
//				System.out.println("uncompleted tasks: " + listOfCompletedTasks.indexOf(task));
				task.setTaskListener(ToDo.this);
				panel1.add(task.getGuiComponent());
				frame.revalidate();
			}
		});
		
		
		AddStudyTaskButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Task task = new StudyTask();
				listOfTasks.addLast(task);
				listOfCompletedTasks.addLast(task);
//				typeArray[i++]=2;
				totalTasksInt++;
				status.setText(completedTasksInt + " out of " + totalTasksInt + " tasks completed");
				System.out.println(listOfTasks.indexOf(task));
				task.setTaskListener(ToDo.this);
				panel1.add(task.getGuiComponent());
				frame.revalidate();
			}
		});
	
	
		AddCustomTaskButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Task task = new CustomTask();
				listOfTasks.addLast(task);
				listOfCompletedTasks.addLast(task);
//				typeArray[i++]=3;
				totalTasksInt++;
				status.setText(completedTasksInt + " out of " + totalTasksInt + " tasks completed");
				System.out.println(listOfTasks.indexOf(task));
				task.setTaskListener(ToDo.this);
				panel1.add(task.getGuiComponent());
				frame.revalidate();
				
			}
		});
	
		


		JButton SortAlphabetButton = new JButton("A-Ö");
		panel2.add(SortAlphabetButton);
		SortAlphabetButton.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e) {
		            	
		            	Comparator<Task> comparator = new ComparatorTaskType();


                        //Collections.sort(listOfTasks, comparator);
                        listOfTasks.sort(comparator);
		                frame.revalidate();
		                rebuildTaskPanel();
		            }
		});
		
	}
	
	
	
	

	@Override
	public void taskChanged(Task t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taskCompleted(Task t) {
		// TODO Auto-generated method stub
		listOfCompletedTasks.remove(this.task);
		completedTasksInt++;
		 status.setText(completedTasksInt + " out of " + totalTasksInt + " tasks completed");
		panel1.revalidate();
	    panel1.repaint();
		
	}

	@Override
	public void taskUncompleted(Task t) {
		// TODO Auto-generated method stub
		listOfCompletedTasks.add(this.task);
		completedTasksInt--;
		status.setText(completedTasksInt + " out of " + totalTasksInt + " tasks completed");
		panel1.revalidate();
	    panel1.repaint();
	}

	@Override
	public void taskCreated(Task t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void taskRemoved(Task t) {
		panel1.remove(t.getGuiComponent());
		listOfCompletedTasks.remove(this.task);
	    listOfTasks.remove(this.task);
	    totalTasksInt--;
	    if (t.isComplete()==true) {
	    	completedTasksInt--;
	    }
	    status.setText(completedTasksInt + " out of " + totalTasksInt + " tasks completed");
	    panel1.revalidate();
	    panel1.repaint();
	}
	
	}