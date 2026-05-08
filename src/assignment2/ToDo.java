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

//	public TaskListener frame;
	public JPanel buttonPanel1;
	public JPanel buttonPanel2;
	private JPanel taskPanel;
	public LinkedList<Task> listOfTasks;
	public LinkedList<Task> listOfUncompletedTasks;
	public JLabel status;
	public int totalTasksInt;
	public int completedTasksInt;
//	private Buttons buttons = new Buttons(this);
	JFrame frame = new JFrame();

	public ToDo() {
//		JFrame frame = new JFrame();

		status = new JLabel(completedTasksInt + " out of " + totalTasksInt + " completed");

		frame.setSize(750, 550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.setResizable(false);

		taskPanel = new JPanel(new BorderLayout());
		taskPanel.setLayout(new BoxLayout(taskPanel, 1));
//		taskPanel.setBackground(Color.blue);

		JPanel topPanel = new JPanel();
		topPanel.setLayout(new BoxLayout(topPanel, 1));
		
		buttonPanel1 = new JPanel();
		
		JButton addHomeTaskButton = Buttons.createButton("Add Home Task", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newTask(new HomeTask());
			}
		});
		
		JButton addStudyTaskButton = Buttons.createButton("Add Study Task", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newTask(new StudyTask());
			}
		});

		JButton addCustomTaskButton = Buttons.createButton("Add Detailed Task", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newTask(new CustomTask());
			}
		});
		
		buttonPanel1.add(addHomeTaskButton);
		buttonPanel1.add(addStudyTaskButton);
		buttonPanel1.add(addCustomTaskButton);
		buttonPanel1.add(status);
//		buttonPanel1.setBackground(Color.GREEN);
		
		buttonPanel2 = new JPanel();
		
		JButton sortAlphabeticalButton = Buttons.createButton("Sort by A-Ö", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comparatorTaskText();
			}
		});
		
		JButton sortTaskTypeButton = Buttons.createButton("Sort by type Detailed-Home-Study", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comparatorTaskType();
			}
		});
		
		JButton sortTaskCompletionButton = Buttons.createButton("Sort by Uncompleted-Completed", new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comparatorTaskCompletion();
			}
		});
		
		buttonPanel2.add(sortAlphabeticalButton);
		buttonPanel2.add(sortTaskTypeButton);
		buttonPanel2.add(sortTaskCompletionButton);
//		buttonPanel2.setBackground(Color.red);

		topPanel.add(buttonPanel1);
		topPanel.add(buttonPanel2);

		JScrollPane scroll = new JScrollPane(taskPanel);
		frame.add(scroll, BorderLayout.CENTER);
		frame.add(topPanel, BorderLayout.NORTH);

		listOfTasks = new LinkedList<Task>();
		listOfUncompletedTasks = new LinkedList<Task>();

		scroll.setViewportView(taskPanel);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		frame.setVisible(true);
	}

	public void comparatorTaskText() {
		Comparator<Task> comparator = new ComparatorTaskText();
		Collections.sort(listOfTasks, comparator);
		frame.revalidate();
		rebuildTaskPanel();
	}

	public void comparatorTaskType() {
		Comparator<Task> comparator = new ComparatorTaskType();
		Collections.sort(listOfTasks, comparator);
		frame.revalidate();
		rebuildTaskPanel();
	}

	public void comparatorTaskCompletion() {
		Comparator<Task> comparator = new ComparatorTaskCompletion();
		Collections.sort(listOfTasks, comparator);
		frame.revalidate();
		rebuildTaskPanel();
	}

	public void newTask(Task task) {
		listOfTasks.addLast(task);
		listOfUncompletedTasks.addLast(task);
		totalTasksInt++;
		status.setText(completedTasksInt + " out of " + totalTasksInt + " tasks completed");
//		System.out.println(listOfTasks.indexOf(task));
		task.setTaskListener(this);
		taskPanel.add(task.getGuiComponent());
		taskPanel.revalidate();
		taskPanel.repaint();
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
	}

	@Override
	public void taskCreated(Task t) {
	}
}