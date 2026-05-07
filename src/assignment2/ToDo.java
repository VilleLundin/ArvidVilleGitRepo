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

	private JPanel taskPanel;
	private LinkedList<Task> listOfTasks;
	private LinkedList<Task> listOfUncompletedTasks;
	private JLabel status;
	private int totalTasksInt;
	private int completedTasksInt;

	public ToDo() {
		JFrame frame = new JFrame();

		frame.setSize(750, 550);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		taskPanel = new JPanel(new BorderLayout());
//		panel1.setBackground(Color.green);
//	panel1.setBounds(0, 80, 737, 433);
		taskPanel.setLayout(new BoxLayout(taskPanel, 1));

		JPanel buttonPanel = new JPanel(new BorderLayout());
//		panel2.setBackground(Color.WHITE);
		buttonPanel.setBounds(0, 0, 737, 80);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, 0));

		JScrollPane scroll = new JScrollPane(taskPanel);
		frame.add(scroll, BorderLayout.CENTER);
		frame.add(buttonPanel, BorderLayout.NORTH);

		JButton AddHomeTaskButton = new JButton("New Home task");
		JButton AddStudyTaskButton = new JButton("New Study task");
		JButton AddCustomTaskButton = new JButton("New Detailed task");

		status = new JLabel(completedTasksInt + " out of " + totalTasksInt + " completed");

		listOfTasks = new LinkedList<Task>();
		listOfUncompletedTasks = new LinkedList<Task>();

		buttonPanel.add(AddHomeTaskButton);
		buttonPanel.add(AddStudyTaskButton);
		buttonPanel.add(AddCustomTaskButton);
		buttonPanel.add(status);

		scroll.setViewportView(taskPanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		AddHomeTaskButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Task task = new HomeTask();
				listOfTasks.addLast(task);
				listOfUncompletedTasks.addLast(task);
				totalTasksInt++;
				status.setText(completedTasksInt + " out of " + totalTasksInt + " tasks completed");
				task.setTaskListener(ToDo.this);
				taskPanel.add(task.getGuiComponent());
				frame.revalidate();
			}
		});

		AddStudyTaskButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Task task = new StudyTask();
				listOfTasks.addLast(task);
				listOfUncompletedTasks.addLast(task);
				totalTasksInt++;
				status.setText(completedTasksInt + " out of " + totalTasksInt + " tasks completed");
				System.out.println(listOfTasks.indexOf(task));
				task.setTaskListener(ToDo.this);
				taskPanel.add(task.getGuiComponent());
				frame.revalidate();
			}
		});

		AddCustomTaskButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Task task = new CustomTask();
				listOfTasks.addLast(task);
				listOfUncompletedTasks.addLast(task);
				totalTasksInt++;
				status.setText(completedTasksInt + " out of " + totalTasksInt + " tasks completed");
				System.out.println(listOfTasks.indexOf(task));
				task.setTaskListener(ToDo.this);
				taskPanel.add(task.getGuiComponent());
				frame.revalidate();
			}
		});

		JButton sortAlphabetButton = new JButton("Sort by A-Ö");
		buttonPanel.add(sortAlphabetButton);
		sortAlphabetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Comparator<Task> comparator = new ComparatorTaskText();

				Collections.sort(listOfTasks, comparator);
				frame.revalidate();
				rebuildTaskPanel();
			}
		});
		
		
		JButton sortTaskTypeButton = new JButton("Sort by type Detailed-Home-Study");
		buttonPanel.add(sortTaskTypeButton);
		sortTaskTypeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Comparator<Task> comparator = new ComparatorTaskType();

				Collections.sort(listOfTasks, comparator);
				frame.revalidate();
				rebuildTaskPanel();
			}
		});
		
		
		
		JButton sortTaskCompletionButton = new JButton("Sort by Uncompleted-Completed");
		buttonPanel.add(sortTaskCompletionButton);
		sortTaskCompletionButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Comparator<Task> comparator = new ComparatorTaskCompletion();

				Collections.sort(listOfTasks, comparator);
				frame.revalidate();
				rebuildTaskPanel();
			}
		});

	}
	
	private void rebuildTaskPanel() {
		taskPanel.removeAll();

		for (Task t : listOfTasks) {
			taskPanel.add(t.getGuiComponent());
		}

		taskPanel.revalidate();
		taskPanel.repaint();
	}

	@Override
	public void taskCompleted(Task t) {
		listOfUncompletedTasks.remove(t);
		completedTasksInt++;
		status.setText(completedTasksInt + " out of " + totalTasksInt + " tasks completed");
		taskPanel.revalidate();
		taskPanel.repaint();

	}

	@Override
	public void taskUncompleted(Task t) {
		listOfUncompletedTasks.add(t);
		completedTasksInt--;
		status.setText(completedTasksInt + " out of " + totalTasksInt + " tasks completed");
		taskPanel.revalidate();
		taskPanel.repaint();
	}

	@Override
	public void taskRemoved(Task t) {
		taskPanel.remove(t.getGuiComponent());
		listOfUncompletedTasks.remove(t);
		listOfTasks.remove(t);
		totalTasksInt--;
		
		if (t.isComplete() == true) {
			completedTasksInt--;
		}
		
		status.setText(completedTasksInt + " out of " + totalTasksInt + " tasks completed");
		taskPanel.revalidate();
		taskPanel.repaint();
	}
	
	@Override
	public void taskChanged(Task t) {
		// TODO Auto-generated method stub
	}
	
	@Override
	public void taskCreated(Task t) {
		// TODO Auto-generated method stub
	}

}